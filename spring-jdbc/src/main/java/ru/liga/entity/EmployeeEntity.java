package ru.liga.entity;

import java.time.LocalDate;

public class EmployeeEntity {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (department_id != null ? !department_id.equals(that.department_id) : that.department_id != null)
            return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        return birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (department_id != null ? department_id.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + birthday.hashCode();
        return result;
    }

    @Override

    public String toString() {
        return "EmployeeEntity{" +
                "id='" + id + '\'' +
                ", fio='" + fio + '\'' +
                ", gender='" + gender + '\'' +
                ", department_id='" + department_id + '\'' +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    private Long id;
    private String fio;
    private String gender;
    private Long department_id;
    private String degree;
    private String position;
    private LocalDate birthday;

    public EmployeeEntity(Long id, String fio, String gender, Long department_id, String degree, String position, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department_id = department_id;
        this.degree = degree;
        this.position = position;
        this.birthday = birthday;
    }

    public EmployeeEntity() {
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

    public String getGender() {
        return gender;
    }

    public Long getDepartmentId() {
        return department_id;
    }

    public String getDegree() {
        return degree;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
