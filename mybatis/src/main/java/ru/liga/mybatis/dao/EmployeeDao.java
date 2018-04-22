package ru.liga.mybatis.dao;

import ru.liga.mybatis.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDao {

    EmployeeEntity insert(EmployeeEntity entity);

    EmployeeEntity update(EmployeeEntity entity);

    void delete(Long entityId);

    EmployeeEntity select(Long id);

    List<EmployeeEntity> selectByDepartmentId(Long departmentId);

}
