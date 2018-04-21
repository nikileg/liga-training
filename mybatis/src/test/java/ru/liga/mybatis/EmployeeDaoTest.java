package ru.liga.mybatis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.mybatis.config.TestDaoSpringConfig;
import ru.liga.mybatis.dao.EmployeeDao;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Before
    public void init() {

    }

    @Test
    public void selectById() {
        assertEquals("Владимир Николаевич Чубариков", employeeDao.select(1L).getFio());
    }
    @Test
    public void selectByDepartmentId() {
        assertEquals(4, employeeDao.selectByDepartmentId(1L).size());
    }

}