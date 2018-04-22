package ru.liga.hibernate.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fio", nullable = false)
    private String fio;
    @Column(name = "gender", nullable = false)
    private String gender;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "title", nullable = false)
    private DepartmentEntity department;
    @Column(name = "course", nullable = false)
    private Integer course;
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String fio, String gender, DepartmentEntity department, Integer course, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department = department;
        this.course = course;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
