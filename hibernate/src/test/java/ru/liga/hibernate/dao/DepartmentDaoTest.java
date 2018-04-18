package ru.liga.hibernate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.liga.hibernate.entity.DepartmentEntity;
import ru.liga.hibernate.entity.EmployeeEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentDaoTest {
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void selectTest() {
        DepartmentEntity entity = departmentDao.select(0L);
        assertEquals("Механико-математический", entity.getTitle());
        assertEquals("119991, ГСП-1, Москва, Ленинские горы, МГУ, д.1, Главное здание, механико-математический факультет", entity.getAddress());
        assertEquals(5, entity.getEmployees().size());
        assertEquals(Integer.valueOf(1932), entity.getFoundationYear());
    }
    @Test
    public void selectByIdTest() {
        DepartmentEntity entity = departmentDao.selectById(0L);
        assertEquals("Механико-математический", entity.getTitle());
        assertEquals("119991, ГСП-1, Москва, Ленинские горы, МГУ, д.1, Главное здание, механико-математический факультет", entity.getAddress());
        assertEquals(5, entity.getEmployees().size());
        assertEquals(Integer.valueOf(1932), entity.getFoundationYear());
    }

    @Test
    public void selectByFoundationYearTest() {
        List<DepartmentEntity> entities = departmentDao.selectByFoundationYear(1934);
        assertEquals(1, entities.size());
    }

    @Test
    public void saveTest() {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setTitle("Психологический");
        entity.setFoundationYear(1948);
        entity.setAddress("Москва");
        entity.setEmployees(Arrays.asList(new EmployeeEntity(null, "Chernoded Anton Aleksadrovich", "FEMALE", entity, "MASTER", "postgraduate", LocalDate.now())));
        departmentDao.save(entity);
        DepartmentEntity savedEntity = departmentDao.select(entity.getId());
        assertTrue(
                savedEntity.getEmployees()
                        .stream()
                        .anyMatch(e -> e.getFio().equals("Chernoded Anton Aleksadrovich"))
        );
    }
}