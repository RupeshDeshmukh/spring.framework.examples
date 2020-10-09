/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example10.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.atos.spring.training.example10.dto.Employee;

/**
 * Row Mapper for mapping result set data into Employee object.
 * 
 * @author Rupesh Deshmukh
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

    /**
     * {@inheritDoc}
     */
    public Employee mapRow(final ResultSet rs, final int rowNum) throws SQLException {

        final Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setSalaryCode(rs.getInt("salary_code"));

        return employee;
    }

}
