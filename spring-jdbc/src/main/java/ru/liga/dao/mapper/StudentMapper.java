package ru.liga.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.entity.StudentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<StudentEntity> {
    @Override
    public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new StudentEntity(
                rs.getLong("id"),
                rs.getString("fio"),
                rs.getString("gender"),
                rs.getLong("department_id"),
                rs.getInt("course"),
                rs.getDate("birthday").toLocalDate()
        );
    }
}
