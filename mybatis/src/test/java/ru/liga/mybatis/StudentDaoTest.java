package ru.liga.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.mybatis.config.TestDaoSpringConfig;
import ru.liga.mybatis.dao.StudentDao;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void selectById() {
        assertEquals("Бардашов Данила Романович", studentDao.select(1L).getFio());
    }

    @Test
    public void selectByDepartmentId() {
        assertEquals(16, studentDao.selectByDepartmentId(1L).size());
    }

}
