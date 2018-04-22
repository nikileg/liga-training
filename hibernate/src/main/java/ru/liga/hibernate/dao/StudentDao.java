package ru.liga.hibernate.dao;

import ru.liga.hibernate.entity.StudentEntity;

import java.util.List;

public interface StudentDao {
    void save(StudentEntity entity);

    void delete(Long entityId);

    StudentEntity select(Long id);

    List<StudentEntity> selectByDepartmentTitle(String title);

    StudentEntity selectByFio(String fio);
}
