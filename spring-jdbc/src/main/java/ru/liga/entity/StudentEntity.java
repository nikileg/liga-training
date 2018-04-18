package ru.liga.entity;

import java.time.LocalDate;

public class StudentEntity {
    private Long id;
    private String fio;
    private String gender;
    private Long department_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity entity = (StudentEntity) o;

        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (fio != null ? !fio.equals(entity.fio) : entity.fio != null) return false;
        if (gender != null ? !gender.equals(entity.gender) : entity.gender != null) return false;
        if (department_id != null ? !department_id.equals(entity.department_id) : entity.department_id != null)
            return false;
        if (course != null ? !course.equals(entity.course) : entity.course != null) return false;
        return birthday != null ? birthday.equals(entity.birthday) : entity.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (department_id != null ? department_id.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    private Integer course;
    private LocalDate birthday;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String fio, String gender, Long department_id, Integer course, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department_id = department_id;
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

    public Long getDepartmentId() {
        return department_id;
    }

    public void setDepartmentId(Long department_id) {
        this.department_id = department_id;
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
