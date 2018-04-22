package ru.liga.hibernate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void selectById() {
        assertEquals("Бардашов Данила Романович", studentDao.select(0L).getFio());
    }

    @Test
    public void selectByDepartmentId() {
        assertEquals(16,
                studentDao.selectByDepartmentTitle("Механико-математический").size());
    }

}
