package com.mahendracandi.springhibernate.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "JOINING_DATE", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningDate;

    @Column(name = "SALARY", nullable = false)
    private BigDecimal salary;

    @Column(name = "SSN", unique = true, nullable = false)
    private String ssn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && Objects.equals(getName(), employee.getName()) && Objects.equals(getJoiningDate(), employee.getJoiningDate()) && Objects.equals(getSalary(), employee.getSalary()) && Objects.equals(getSsn(), employee.getSsn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getJoiningDate(), getSalary(), getSsn());
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", joiningDate=" + joiningDate + ", salary=" + salary + ", ssn='" + ssn + '\'' + '}';
    }
}
