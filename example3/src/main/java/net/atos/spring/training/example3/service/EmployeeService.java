/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example3.service;

import java.util.Set;

import net.atos.spring.training.example3.dto.Employee;
import net.atos.spring.training.example3.dto.SearchCriteria;

/**
 * Service for managing employee information.
 * 
 * @author Rupesh Deshmukh
 */
public interface EmployeeService {

    /**
     * Method to search all employees matching given search criteria.
     * 
     * @param searchCriteria
     *            <code>net.atos.spring.training.example3.dto.SearchCriteria</code>
     * @return List of
     *         <code>net.atos.spring.training.example3.dto.Employee</code>
     */
    Set<Employee> searchEmployee(final SearchCriteria searchCriteria);
}
