/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example3.dao;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import net.atos.spring.training.example3.dto.Employee;
import net.atos.spring.training.example3.dto.SearchCriteria;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example3.dao.EmployeeDAO</code>.
 * 
 * @author Rupesh Deshmukh
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private Set<Employee> employees;

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee findEmployeeBySalaryCode(final int salaryCode) {

        final Set<Employee> searchedEmployees =
                        this.employees.stream().filter(e -> e.getSalaryCode() == salaryCode).collect(Collectors.toCollection(HashSet::new));
        if (!CollectionUtils.isEmpty(searchedEmployees)) {
            return searchedEmployees.iterator().next();
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Employee> findAllEmployees() {
        return this.employees;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Employee> findEmployeesBySearchCriteria(final SearchCriteria searchCriteria) {

        return this.employees.stream().filter(e -> e.getFirstName().equals(searchCriteria.getFirstName())
                        || e.getLastName().equals(searchCriteria.getLastName()) || e.getSalaryCode() == searchCriteria.getSalaryCode())
                        .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * Getter for employees.
     * 
     * @return the employees
     */
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    /**
     * Setter for employees.
     * 
     * @param employees
     *            the employees to set
     */
    public void setEmployees(final Set<Employee> employees) {
        this.employees = employees;
    }

}
