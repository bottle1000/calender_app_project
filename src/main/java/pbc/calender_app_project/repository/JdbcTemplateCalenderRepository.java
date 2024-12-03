package pbc.calender_app_project.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.entity.Calender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        parameters.put("todo_list", calender.getToDoList());
        parameters.put("name", calender.getName());
        parameters.put("password", calender.getPassword());
        parameters.put("created_at", LocalDateTime.now());
        parameters.put("updated_at", LocalDateTime.now());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new CalenderResponseDto(key.longValue(), calender.getToDoList(), calender.getName());
    }

    @Override
    public List<CalenderResponseDto> findAllCalenders() {
        return jdbcTemplate.query("select * from calender", calenderMapper());
    }

    private RowMapper<CalenderResponseDto> calenderMapper() {
        return new RowMapper<CalenderResponseDto>() {
            @Override
            public CalenderResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new CalenderResponseDto(
                       rs.getTimestamp("updated_at").toLocalDateTime().toLocalDate(),
                        rs.getString("name")
                );
            }
        };
    }


}
