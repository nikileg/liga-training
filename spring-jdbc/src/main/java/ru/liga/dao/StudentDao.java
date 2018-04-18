package ru.liga.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.liga.dao.mapper.StudentMapper;
import ru.liga.entity.StudentEntity;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentEntity save(StudentEntity entity) {
        if (findById(entity.getId()) == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    public StudentEntity findById(Long id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        List<StudentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new StudentMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }

    public List<StudentEntity> findAll() {
        String sql = "SELECT * FROM student";
        List<StudentEntity> entities = jdbcTemplate.query(sql, new StudentMapper());
        return entities;
    }

    public StudentEntity insert(StudentEntity entity) {
        String sql = "INSERT INTO student (fio, gender, department_id, course, birthday)" +
                " VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                    ps.setString(1, entity.getFio());
                    ps.setString(2, entity.getGender());
                    ps.setLong(3, entity.getDepartmentId());
                    ps.setInt(4, entity.getCourse());
                    ps.setTimestamp(5,
                            Timestamp.valueOf(entity.getBirthday().atStartOfDay()));
                    return ps;
                },
                keyHolder
        );
        Long id = keyHolder.getKey().longValue();
        entity.setId(id);
        return entity;
    }

    public StudentEntity update(StudentEntity entity) {
        String sql = "UPDATE student (fio, gender, department_id, course, birthday)" +
                "SET VALUES (?, ?, ?, ?, ?) WHERE id = ?";
        jdbcTemplate.update(sql,
                entity.getFio(),
                entity.getGender(),
                entity.getDepartmentId(),
                entity.getCourse(),
                entity.getBirthday(),
                entity.getId()
        );
        return entity;
    }

    public void delete(Long id) {
        String sqlDelete = "DELETE FROM student WHERE id = ?";
        jdbcTemplate.update(sqlDelete, id);
    }
}
