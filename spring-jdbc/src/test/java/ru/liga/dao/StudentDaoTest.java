package ru.liga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.entity.StudentEntity;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;
    private StudentEntity INSERT_ENTITY = new StudentEntity(
            null,
            "Никитин Олег Александрович",
            "MALE",
            1L,
            4,
            LocalDate.of(1997, 8, 4)
    );

    @Test
    public void insertThenFindThenDelete() {
        System.out.println(INSERT_ENTITY);
        StudentEntity insertResult = studentDao.insert(INSERT_ENTITY);
        Long id = insertResult.getId();
        StudentEntity findResult = studentDao.findById(id);
        assertEquals(insertResult, findResult);
        assertEquals(INSERT_ENTITY, findResult);
        studentDao.delete(id);
        findResult = studentDao.findById(id);
        assertEquals(null, findResult);
    }

    @Test
    public void findNotExisting() {
        final Long id = Long.MAX_VALUE;
        StudentEntity foundEmployee = studentDao.findById(id);
        assertEquals(null, foundEmployee);
    }

    @Test
    public void findById6() {
        final String expectedFio = "Гайнуллина Галия Тагировна";
        final Long id = 6L;
        StudentEntity foundEmployee = studentDao.findById(id);
        System.out.println(foundEmployee);
        assertEquals(expectedFio, foundEmployee.getFio());
    }
}
