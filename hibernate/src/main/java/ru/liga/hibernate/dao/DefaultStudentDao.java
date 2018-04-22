package ru.liga.hibernate.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.hibernate.entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class DefaultStudentDao implements StudentDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(StudentEntity entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Long entityId) {
        em.remove(select(entityId));
    }

    @Override
    public StudentEntity select(Long id) {
        return em.find(StudentEntity.class, id);
    }

    @Override
    public List<StudentEntity> selectByDepartmentTitle(String title) {
        return em
                .createQuery("FROM StudentEntity WHERE department_id = :departmentId", StudentEntity.class)
                .setParameter("departmentId", title)
                .getResultList();
    }

    @Override
    public StudentEntity selectByFio(String fio) {
        return em
                .createQuery("FROM StudentEntity WHERE fio = :fio", StudentEntity.class)
                .setParameter("fio", fio)
                .getSingleResult();
    }
}
