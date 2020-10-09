/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example14.service;

import java.util.List;

import net.atos.spring.training.example14.dto.EmployeeSearch;
import net.atos.spring.training.example14.entity.Employee;

/**
 * Service for managing employee information.
 * 
 * @author Rupesh Deshmukh
 */
public interface EmployeeService {

    /**
     * Method create a new employee record in DB.
     * 
     * @param employee
     *            <code>net.atos.spring.training.example14.entity.Employee</code>
     *            .
     * @return <code>net.atos.spring.training.example14.entity.Employee</code>.
     */
    Employee create(final Employee employee);

    /**
     * Method to fetch employee details for the given employee Id.
     * 
     * @param id
     *            Integer.
     * @return <code>net.atos.spring.training.example14.entity.Employee</code>.
     */
    Employee read(final Integer id);

    /**
     * Method to update employee details.
     * 
     * @param employee
     *            <code>net.atos.spring.training.example14.entity.Employee</code>
     *            .
     */
    void update(final Employee employee);

    /**
     * Method to delete the given employee record from DB.
     * 
     * @param id
     *            Integer.
     */
    void delete(final Integer id);

    /**
     * Method to find a particular employee for the given salary code.
     * 
     * @param salaryCode
     *            int.
     * @return <code>net.atos.spring.training.example14.entity.Employee</code>.
     */
    Employee findEmployeeBySalaryCode(final int salaryCode);

    /**
     * Method to find all employees.
     * 
     * @return List of
     *         <code>net.atos.spring.training.example14.entity.Employee</code>.
     */
    List<Employee> findAllEmployees();

    /**
     * Method to find employees based on the given search criteria.
     * 
     * @param employeeSearch
     *            <code>net.atos.spring.training.example14.dto.EmployeeSearch</code>
     *            .
     * @return List of
     *         <code>net.atos.spring.training.example14.entity.Employee</code>.
     */
    List<Employee> findEmployeesBySearchCriteria(final EmployeeSearch employeeSearch);

    /**
     * Method to count all employees with given firstName.
     * 
     * @param firstName
     *            String.
     * @return int count of employees.
     */
    int countEmployeesByFirstName(final String firstName);

    /**
     * Method to count all employees with given employee details.
     * 
     * @param employee
     *            <code>net.atos.spring.training.example14.entity.Employee</code>
     *            .
     * @return int count of employees.
     */
    int countEmployees(final Employee employee);
}
