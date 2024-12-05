package pbc.calender_app_project.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.entity.Author;
import pbc.calender_app_project.entity.Calender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Repository
public class JdbcTemplateCalenderRepository implements CalenderRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateCalenderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CalenderResponseDto createCalender(Calender calender) {

        Author author = calender.getAuthor();

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("calender").usingGeneratedKeyColumns("id");


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("todo_list", calender.getTodoList());
        parameters.put("password", calender.getPassword());
        parameters.put("created_at", LocalDateTime.now());
        parameters.put("updated_at", LocalDateTime.now());
        parameters.put("author_id", author.getId());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new CalenderResponseDto(key.longValue(), calender.getTodoList(), author);
    }

    @Override
    public List<Calender> findAllCalenders() {
        List<Calender> query = jdbcTemplate.query(
                "select c.id as calender_id, c.todo_list, c.password, c.created_at, c.updated_at, c.author_id, " +
                        "a.name, a.email, a.created_at, a.updated_at " +
                        "from calender c " +
                        "join author a on c.author_id = a.id", calenderRowMapper());
        return query;
    }

    @Override
    public List<Calender> findById(Long id) {
        return jdbcTemplate.query("select c.id as calender_id, c.todo_list, c.password, c.created_at, c.updated_at, " +
                "a.id as author_id, a.name, a.email, a.created_at, a.updated_at " +
                "from calender c " +
                "join author a on c.author_id = a.id " +
                "where a.id = ?" , calenderRowMapper(), id);
    }

    @Transactional
    @Override
    public void updateTodoListAndName(Long id, String todoList, String name) {
        Long authorId = jdbcTemplate.queryForObject("select author_id from calender where id = ?", Long.class, id);

        if (authorId != null) {
            jdbcTemplate.update("update calender set todo_list = ? where id = ?", todoList, id);

            jdbcTemplate.update("update author set name = ? where id = ?", name, authorId);
        }
    }



    @Override
    public int removeCalender(Long id) {
        return jdbcTemplate.update("delete from calender where id = ? ;", id);
    }




    private RowMapper<Calender> calenderRowMapper() {
        return new RowMapper<Calender>() {
            @Override
            public Calender mapRow(ResultSet rs, int rowNum) throws SQLException {

                Author author = new Author(
                        rs.getLong("author_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("created_at").toLocalDate(),
                        rs.getDate("updated_at").toLocalDate()
                );

                return new Calender(
                        rs.getLong("calender_id"),
                        rs.getString("todo_list"),
                        rs.getString("password"),
                        rs.getDate("created_at").toLocalDate(),
                        rs.getDate("updated_at").toLocalDate(),
                        author
                );
            }
        };
    }
}
