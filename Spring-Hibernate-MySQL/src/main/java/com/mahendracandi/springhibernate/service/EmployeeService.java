package com.mahendracandi.springhibernate.service;

import com.mahendracandi.springhibernate.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    List<Employee> findAllEmployee();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);
}
