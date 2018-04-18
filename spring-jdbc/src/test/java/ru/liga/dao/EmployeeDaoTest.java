package ru.liga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.entity.EmployeeEntity;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;
    private EmployeeEntity INSERT_ENTITY = new EmployeeEntity(
            null,
            "Никитин Олег Александрович",
            "MALE",
            1L,
            "MASTER",
            "OVERLORD",
            LocalDate.of(1997, 8, 4)
    );

    @Test
    public void insertThenFindThenDelete() {
        System.out.println(INSERT_ENTITY);
        EmployeeEntity insertResult = employeeDao.insert(INSERT_ENTITY);
        Long id = insertResult.getId();
        EmployeeEntity findResult = employeeDao.findById(id);
        assertEquals(insertResult, findResult);
        assertEquals(INSERT_ENTITY, findResult);
        employeeDao.delete(id);
        findResult = employeeDao.findById(id);
        assertEquals(null, findResult);
    }

    @Test
    public void findNotExisting() {
        final Long id = Long.MAX_VALUE;
        EmployeeEntity foundEmployee = employeeDao.findById(id);
        assertEquals(null, foundEmployee);
    }

    @Test
    public void findById6() {
        final String expectedFio = "Штерн Александр Исаакович";
        final Long id = 6L;
        EmployeeEntity foundEmployee = employeeDao.findById(id);
        System.out.println(foundEmployee);
        assertEquals(expectedFio, foundEmployee.getFio());
    }
}
