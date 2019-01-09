package com.mahendracandi.springhibernate;

import com.mahendracandi.springhibernate.configuration.AppConfig;
import com.mahendracandi.springhibernate.model.Employee;
import com.mahendracandi.springhibernate.service.EmployeeService;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Logger log = Logger.getLogger(App.class);

        // Create Employee 1
        Employee employee1 = new Employee();
        employee1.setName("Fayt Leingod");
        employee1.setJoiningDate(new LocalDate(2018, 1, 20));
        employee1.setSalary(new BigDecimal(3800000));
        employee1.setSsn("emp001");
        //employeeService.saveEmployee(employee1);

        // Create Employee 2
        Employee employee2 = new Employee();
        employee2.setName("Nel");
        employee2.setJoiningDate(new LocalDate(2017, 6, 19));
        employee2.setSalary(new BigDecimal(3800000));
        employee2.setSsn("emp002");
        //employeeService.saveEmployee(employee2);

        // find all employee
        List<Employee> listEmp = employeeService.findAllEmployee();
        for (Employee emp : listEmp) {
            log.debug(emp.getId());
            log.debug(emp.getName());
            log.debug(emp.getJoiningDate());
            log.debug(emp.getSalary());
            log.debug(emp.getSsn());
        }

        context.close();
    }
}
