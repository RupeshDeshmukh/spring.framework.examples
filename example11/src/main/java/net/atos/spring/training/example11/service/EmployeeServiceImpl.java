/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example11.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.atos.spring.training.example11.dao.EmployeeDAO;
import net.atos.spring.training.example11.entity.Employee;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example3.service.EmployeeService</code>
 * 
 * @author Rupesh Deshmukh
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /**
     * Employee DAO instance that will be initialized by spring using
     * constructor injection.
     */
    @Autowired
    private EmployeeDAO employeDAO;

    /**
     * {@inheritDoc}
     */
    public Employee create(final Employee employee) {

        LOGGER.info("Creating new employee record: " + employee.toString());

        final Employee newEmployee = this.getEmployeDAO().create(employee);

        LOGGER.info("Employee created successfully with Id: " + employee.getId());

        return newEmployee;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public Employee read(final Integer id) {

        LOGGER.info("Fetching employee details for Employee Id: " + id);

        final Employee employee = this.getEmployeDAO().read(id);

        if (employee != null) {
            LOGGER.info("Employee details with employee id: " + id + " are: " + employee.toString());
        } else {
            LOGGER.warn("No employee found with Employee Id: " + id);
        }

        return employee;
    }

    /**
     * {@inheritDoc}
     */
    public void update(final Employee employee) {

        LOGGER.info("Updating employee details: " + employee.toString());

        this.getEmployeDAO().update(employee);

        LOGGER.info("Employee details updated successfully !!!");
    }

    /**
     * {@inheritDoc}
     */
    public void delete(final Integer id) {

        LOGGER.info("Deleting employee record for Id: " + id);

        this.getEmployeDAO().delete(id);

        LOGGER.info("Employee deleted successfully !!!");
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public Employee findEmployeeBySalaryCode(final int salaryCode) {

        LOGGER.info("Fetching employee details for Employee Salary Code: " + salaryCode);

        return this.getEmployeDAO().findEmployeeBySalaryCode(salaryCode);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {

        LOGGER.info("Fetching all employees.");

        return this.getEmployeDAO().findAllEmployees();
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public int countEmployeesByFirstName(String firstName) {

        LOGGER.info("Counting number of employees with first name: " + firstName);

        final int count = this.getEmployeDAO().countEmployeesByFirstName(firstName);

        LOGGER.info("Number of employees with first name: " + firstName + " are: " + count);

        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public int countEmployees(final Employee employee) {

        LOGGER.info("Counting number of employees details: " + employee.toString());

        final int count = this.getEmployeDAO().countEmployees(employee);

        LOGGER.info("Number of employees found are: " + count);

        return count;
    }

    /**
     * Getter for employeDAO.
     * 
     * @return the employeDAO
     */
    public EmployeeDAO getEmployeDAO() {
        return this.employeDAO;
    }

    /**
     * Setter for employeDAO.
     * 
     * @param employeDAO
     *            the employeDAO to set
     */
    public void setEmployeDAO(EmployeeDAO employeDAO) {
        this.employeDAO = employeDAO;
    }

}
