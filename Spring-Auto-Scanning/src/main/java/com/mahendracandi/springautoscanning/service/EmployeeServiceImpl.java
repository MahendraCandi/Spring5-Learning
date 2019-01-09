package com.mahendracandi.springautoscanning.service;

import com.mahendracandi.springautoscanning.dao.EmployeeDao;
import com.mahendracandi.springautoscanning.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DateService dateService;

    @Override
    public void registerEmployee(Employee employee) {
        employee.setAssessmentDate(dateService.getNextAssesstmentDate());
        employeeDao.saveInDatabase(employee);
    }
}
