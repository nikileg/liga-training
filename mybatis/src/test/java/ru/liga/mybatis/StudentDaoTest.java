package ru.liga.mybatis;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.mybatis.config.TestDaoSpringConfig;
import ru.liga.mybatis.dao.StudentDao;
import ru.liga.mybatis.entity.StudentEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {
    List<Long> insert_ids = new ArrayList<>();

    @Autowired
    private StudentDao studentDao;

    @After
    public void cleanInserted() {
        insert_ids.forEach(id -> studentDao.delete(id));
    }

    @Test
    public void selectById() {
        assertEquals("Бардашов Данила Романович", studentDao.select(1L).getFio());
    }

    @Test
    public void selectByDepartmentId() {
        assertEquals(16, studentDao.selectByDepartmentId(1L).size());
    }

    @Test
    public void selectNonExistingId() {
        long ne_id = -1;
        StudentEntity null_student = studentDao.select(ne_id);
        assertNull(null_student);
    }

    @Test
    public void insert() {
        StudentEntity toInsert = new StudentEntity(
                null,
                "test fio",
                "APACHE ATTACK HELICOPTER",
                2L,
                1L,
                LocalDate.now());
        studentDao.insert(toInsert);
        long id = toInsert.getId();
        assertNotNull(id);
        StudentEntity afterInsert = studentDao.select(id);
        assertEquals(toInsert, afterInsert);
        this.insert_ids.add(id);
    }

    @Test
    public void insertAndthenUpdate() {
        final String updatedFio = "fiofiofiofio";
        StudentEntity toInsert = new StudentEntity(
                null,
                "test fio",
                "APACHE ATTACK HELICOPTER",
                2L,
                1L,
                LocalDate.now());
        studentDao.insert(toInsert);
        long id = toInsert.getId();
        toInsert.setFio(updatedFio);
        studentDao.update(toInsert);
        StudentEntity afterUpdate = studentDao.select(id);
        assertEquals(toInsert, afterUpdate);
        this.insert_ids.add(id);
    }

}
