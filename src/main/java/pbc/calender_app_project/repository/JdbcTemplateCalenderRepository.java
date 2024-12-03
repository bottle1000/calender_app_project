package pbc.calender_app_project.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateCalenderRepository implements CalenderRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateCalenderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
