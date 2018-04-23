package ru.liga.mybatis.entity;

import java.time.LocalDate;

public class StudentEntity {
    private Long id;
    private String fio;
    private String gender;
    private Long departmentId;
    private Long course;
    private LocalDate birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        return birthday != null ? birthday.equals(that.birthday) : that.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    public StudentEntity() {

    }

    public StudentEntity(Long id, String fio, String gender, Long departmentId, Long course, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.departmentId = departmentId;
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
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
