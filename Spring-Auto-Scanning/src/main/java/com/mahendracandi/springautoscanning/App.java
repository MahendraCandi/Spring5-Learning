package com.mahendracandi.springautoscanning;

import com.mahendracandi.springautoscanning.configuration.AppConfig;
import com.mahendracandi.springautoscanning.model.Employee;
import com.mahendracandi.springautoscanning.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

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

        Employee employee = new Employee();
        employee.setName("Mahendra Candi");
        employeeService.registerEmployee(employee);

        context.close();
    }
}
