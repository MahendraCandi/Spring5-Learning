package com.mahendracandi.springhibernate.service;

import com.mahendracandi.springhibernate.dao.EmployeeDao;
import com.mahendracandi.springhibernate.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    Logger log = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    EmployeeDao dao;

    @Override
    public void saveEmployee(Employee employee) {
        log.debug("SAVE EMPLOYEE PROCESS");
        dao.saveEmployee(employee);
        log.debug("SAVE EMPLOYEE SUCCESS");
    }

    @Override
    public List<Employee> findAllEmployee() {
        log.debug("FIND ALL EMPLOYEE PROCESS");
        return dao.findAllEmployees();
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        log.debug("DELETE EMPLOYEE PROCESS");
        dao.deleteEmployeeBySsn(ssn);
        log.debug("DELETE EMPLOYEE SUCCESS");
    }

    @Override
    public Employee findBySsn(String ssn) {
        log.debug("FIND EMPLOYEE BY SSN PROCESS");
        return dao.findBySsn(ssn);
    }

    @Override
    public void updateEmployee(Employee employee) {
        log.debug("UPDATE EMPLOYEE PROCESS");
        dao.updateEmployee(employee);
        log.debug("UPDATE EMPLOYEE SUCCESS");
    }
}
