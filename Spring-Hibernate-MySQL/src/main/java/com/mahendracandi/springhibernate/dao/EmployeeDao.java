package com.mahendracandi.springhibernate.dao;

import com.mahendracandi.springhibernate.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);
}
