/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example3.dao;

import java.util.Set;

import net.atos.spring.training.example3.dto.Employee;
import net.atos.spring.training.example3.dto.SearchCriteria;

/**
 * Data Access Object for managing employee data.
 * 
 * @author Rupesh Deshmukh
 */
public interface EmployeeDAO {

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
    Set<Employee> findAllEmployees();

    /**
     * Method to find employees matching given search criteria.
     * 
     * @param searchCriteria
     *            <code>net.atos.spring.training.example3.dto.SearchCriteria</code>
     *            .
     * @return List of
     *         <code>net.atos.spring.training.example3.dto.Employee</code>.
     */
    Set<Employee> findEmployeesBySearchCriteria(final SearchCriteria searchCriteria);
}
