package pbc.calender_app_project.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pbc.calender_app_project.dto.CalenderResponseDto;
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

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("calender").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("todo_list", calender.getTodoList());
        parameters.put("name", calender.getName());
        parameters.put("password", calender.getPassword());
        parameters.put("created_at", LocalDateTime.now());
        parameters.put("updated_at", LocalDateTime.now());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new CalenderResponseDto(key.longValue(), calender.getTodoList(), calender.getName());
    }

    @Override
    public List<Calender> findAllCalenders() {
        List<Calender> query = jdbcTemplate.query("select * from calender", calenderRowMapper());
        return query;
    }

    @Override
    public Optional<Calender> findById(Long id) {
        List<Calender> result = jdbcTemplate.query("select * from calender where id = ?", calenderRowMapper(), id);
        return result.stream().findAny();
    }


    @Override
    public int updateTodoListAndName(Long id, String todoList, String name) {
        return jdbcTemplate.update("update calender set todo_list = ?, name = ? where id = ?", todoList, name, id);
    }

    @Override
    public int removeCalender(Long id) {
        return jdbcTemplate.update("delete from calender where id = ? ;", id);
    }


    private RowMapper<Calender> calenderRowMapper() {
        return new RowMapper<Calender>() {
            @Override
            public Calender mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Calender(
                        rs.getLong("id"),
                        rs.getString("todo_list"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getDate("created_at").toLocalDate(),
                        rs.getDate("updated_at").toLocalDate()
                );
            }
        };
    }


}
