package com.mahendracandi.springhibernate.dao;

import com.mahendracandi.springhibernate.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {
    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("DELETE FROM employee WHERE ssn = :ssn");
        query.setParameter("ssn", ssn);
        query.executeUpdate();
    }

    public Employee findBySsn(String ssn) {
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }

    public void updateEmployee(Employee employee) {
        getSession().update(employee);
    }
}
