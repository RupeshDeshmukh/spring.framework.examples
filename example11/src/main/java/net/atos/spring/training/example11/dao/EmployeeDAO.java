/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example11.dao;

import java.util.List;

import net.atos.spring.training.example11.entity.Employee;

/**
 * Data Access Object for managing employee data.
 * 
 * @author Rupesh Deshmukh
 */
public interface EmployeeDAO {

    /**
     * Method create a new employee record in DB.
     * 
     * @param employee
     *            <code>net.atos.spring.training.example10.dto.Employee</code>.
     * @return <code>net.atos.spring.training.example10.dto.Employee</code>.
     */
    Employee create(final Employee employee);

    /**
     * Method to fetch employee details for the given employee Id.
     * 
     * @param id
     *            Integer.
     * @return <code>net.atos.spring.training.example10.dto.Employee</code>.
     */
    Employee read(final Integer id);

    /**
     * Method to update employee details.
     * 
     * @param employee
     *            <code>net.atos.spring.training.example10.dto.Employee</code>.
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
     * @return <code>net.atos.spring.training.example3.dto.Employee</code>.
     */
    Employee findEmployeeBySalaryCode(final int salaryCode);

    /**
     * Method to find all employees.
     * 
     * @return List of
     *         <code>net.atos.spring.training.example3.dto.Employee</code>.
     */
    List<Employee> findAllEmployees();

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
     *            <code>net.atos.spring.training.example3.dto.Employee</code>..
     * @return int count of employees.
     */
    int countEmployees(final Employee employee);
}
