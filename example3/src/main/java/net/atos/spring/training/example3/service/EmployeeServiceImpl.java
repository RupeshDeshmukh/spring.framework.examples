/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example3.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atos.spring.training.example3.dao.EmployeeDAO;
import net.atos.spring.training.example3.dto.Employee;
import net.atos.spring.training.example3.dto.SearchCriteria;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example3.service.EmployeeService</code>
 * 
 * @author Rupesh Deshmukh
 */
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /**
     * Employee DAO instance that will be initialized by spring using
     * constructor injection.
     */
    private EmployeeDAO employeDAO;

    /**
     * Constructor demonstrating dependency injection feature of Spring. Using
     * constructor to inject dependency is typically called as <b>Constructor
     * Injection</b>.
     * 
     * @param employeDAO
     *            <code>net.atos.spring.training.example3.dao.EmployeDAO</code>.
     */
    public EmployeeServiceImpl(final EmployeeDAO employeDAO) {
        this.employeDAO = employeDAO;
    }

    /**
     * {@inheritDoc}
     */
    public Set<Employee> searchEmployee(final SearchCriteria searchCriteria) {

        LOGGER.info("Searching employees for search criteria: " + searchCriteria.toString());

        return this.employeDAO.findEmployeesBySearchCriteria(searchCriteria);
    }
}
