package ru.liga.mybatis.dao;

import ru.liga.mybatis.entity.StudentEntity;

import java.util.List;

public interface StudentDao {
    void insert(StudentEntity student);

    void update(StudentEntity student);

    void delete(Long studentId);

    StudentEntity select(Long studentId);

    List<StudentEntity> selectByDepartmentId(Long departmentId);

}
