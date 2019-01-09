package com.mahendracandi.springautoscanning.dao;

import com.mahendracandi.springautoscanning.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
    final static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Override
    public void saveInDatabase(Employee employee) {
        log.debug("Employee " + employee.getName() + " is registered for assessment on " + employee.getAssessmentDate());
    }
}
