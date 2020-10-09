/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import net.atos.spring.training.example10.dto.Employee;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example10.dao.EmployeeDAO</code>.
 * 
 * @author Rupesh Deshmukh
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * {@inheritDoc}
     */
    public Employee create(final Employee employee) {

        final String sql = "insert into employee (first_name, last_name, salary_code) values (?, ?, ?)";

        // Key holder instance that will provide us the id of the new row
        // inserted.
        final KeyHolder keyHolder = new GeneratedKeyHolder();

        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getLastName());
                ps.setInt(3, employee.getSalaryCode());
                return ps;
            }
        }, keyHolder);

        employee.setId(keyHolder.getKey().intValue());

        return employee;
    }

    /**
     * {@inheritDoc}
     */
    public Employee read(final Integer id) {

        final String sql = "select * from employee where id = ?";

        final Employee employee = this.getJdbcTemplate().queryForObject(sql, new Object[] {id}, new EmployeeRowMapper());

        return employee;
    }

    /**
     * {@inheritDoc}
     */
    public void update(final Employee employee) {

        final String sql = "update employee set first_name =?, last_name = ?, salary_code = ? where id = ?";

        this.getJdbcTemplate().update(sql, employee.getFirstName(), employee.getLastName(), employee.getSalaryCode(), employee.getId());
    }

    /**
     * {@inheritDoc}
     */
    public void delete(final Employee employee) {

        final String sql = "delete from employee where id = ?";

        this.getJdbcTemplate().update(sql, employee.getId());
    }

    /**
     * {@inheritDoc}
     */
    public Employee findEmployeeBySalaryCode(final int salaryCode) {

        final String sql = "select * from employee where salary_code = ?";

        final Employee employee = this.getJdbcTemplate().queryForObject(sql, new Object[] {salaryCode}, new EmployeeRowMapper());

        return employee;
    }

    /**
     * {@inheritDoc}
     */
    public List<Employee> findAllEmployees() {

        final String sql = "select * from employee";

        final List<Employee> employees = this.getJdbcTemplate().query(sql, new EmployeeRowMapper());

        return employees;
    }

    /**
     * {@inheritDoc}
     */
    public int countEmployeesByFirstName(final String firstName) {

        final String sql = "select count(*) from employee where first_name = :first_name";

        final SqlParameterSource namedParameters = new MapSqlParameterSource("first_name", firstName);

        return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters, Integer.class);
    }

    /**
     * {@inheritDoc}
     */
    public int countEmployees(final Employee employee) {

        final String sql = "select count(*) from employee where first_name = :firstName and last_name = :lastName";

        final SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(employee);

        return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters, Integer.class);
    }

    /**
     * Getter for jdbcTemplate.
     * 
     * @return the jdbcTemplate.
     */
    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    /**
     * Setter for jdbcTemplate.
     * 
     * @param jdbcTemplate
     *            the jdbcTemplate to set.
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Getter for namedParameterJdbcTemplate.
     * 
     * @return the namedParameterJdbcTemplate
     */
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return this.namedParameterJdbcTemplate;
    }

    /**
     * Setter for namedParameterJdbcTemplate.
     * 
     * @param namedParameterJdbcTemplate
     *            the namedParameterJdbcTemplate to set
     */
    public void setNamedParameterJdbcTemplate(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Getter for dataSource.
     * 
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return this.dataSource;
    }

    /**
     * Setter for dataSource.
     * 
     * @param dataSource
     *            the dataSource to set.
     */
    @Autowired
    public void setDataSource(final DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
    }

}
