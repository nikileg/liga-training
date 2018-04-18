package ru.liga.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.liga.dao.mapper.EmployeeMapper;
import ru.liga.entity.EmployeeEntity;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public EmployeeEntity save(EmployeeEntity entity) {
        if (findById(entity.getId()) == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    public EmployeeEntity findById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        List<EmployeeEntity> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new EmployeeMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }

    public List<EmployeeEntity> findAll() {
        String sql = "SELECT * FROM employee";
        List<EmployeeEntity> entities = jdbcTemplate.query(sql, new EmployeeMapper());
        return entities;
    }

    public EmployeeEntity insert(EmployeeEntity entity) {
        String sql = "INSERT INTO employee (fio, gender, department_id, degree, position, birthday)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                    ps.setString(1, entity.getFio());
                    ps.setString(2, entity.getGender());
                    ps.setLong(3, entity.getDepartmentId());
                    ps.setString(4, entity.getDegree());
                    ps.setString(5, entity.getPosition());
                    ps.setTimestamp(6,
                            Timestamp.valueOf(entity.getBirthday().atStartOfDay()));
                    return ps;
                },
                keyHolder
        );
        Long id = keyHolder.getKey().longValue();
        entity.setId(id);
        return entity;
    }

    public EmployeeEntity update(EmployeeEntity entity) {
        String sql = "UPDATE employee SET (fio, gender, department_id, degree, position, birthday)" +
                " = (?, ?, ?, ?, ?, ?) WHERE id = ?";
        jdbcTemplate.update(sql,
                entity.getFio(),
                entity.getGender(),
                entity.getDepartmentId(),
                entity.getDegree(),
                entity.getPosition(),
                Timestamp.valueOf(entity.getBirthday().atStartOfDay()),
                entity.getId());
        return entity;
    }

    public void delete(Long id) {
        String sqlDelete = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sqlDelete, id);
    }
}
