package net.atos.spring.training.example10;
/*
 * Copyright: 2016, Atos.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.atos.spring.training.example10.dto.Employee;
import net.atos.spring.training.example10.service.EmployeeService;

/**
 * Stand-alone main program for executing the
 * <em>Example 10 - Spring JdbcTemplate & NamedParameterJdbcTemplate</em>.
 * 
 * @author Rupesh Deshmukh
 */
public class Example10 {

    /**
     * Main method for execution of example 3.
     * 
     * @param args
     *            String[]
     */
    public static void main(String[] args) {

        /*
         * The interface org.springframework.context.ApplicationContext
         * represents the Spring IoC container and is responsible for
         * instantiating, configuring, and assembling the aforementioned beans.
         * The container gets its instructions on what objects to instantiate,
         * configure, and assemble by reading configuration meta-data. The
         * configuration meta-data is represented in XML, Java annotations, or
         * Java code. It allows you to express the objects that compose your
         * application and the rich interdependencies between such objects.
         * 
         * org.springframework.context.support. ClassPathXmlApplicationContext
         * is one of the implementation of ApplicationContext that can be used
         * to scan XML based spring configuration and perform application
         * wiring.
         */
        final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Fetch the employee service instance using spring context.
        final EmployeeService employeeService = (EmployeeService) context.getBean(EmployeeService.class);

        // Insert a new employee record.
        // employeeService.create(createEmployee());

        // Read the existing.
        final Employee employee = employeeService.read(1);

        // Update the existing employee details.
        // employeeService.update(updateEmployee(employee));

        // Delete the employee.
        // employeeService.delete(employee);

        // Count employees based on first name.
        // employeeService.countEmployeesByFirstName("Rupesh");

        // Count employees based on employee details.
        // final Employee employee = new Employee();
        // employee.setFirstName("Rupesh");
        // employee.setLastName("Deshmukh");
        // employeeService.countEmployees(employee);

        /*
         * Finally we close the application context to avoid leaks within
         * application.
         */
        ((ConfigurableApplicationContext) context).close();
    }

    /**
     * Create employee.
     * 
     * @return <code>net.atos.spring.training.example10.dto.Employee</code>.
     */
    private static Employee createEmployee() {

        final Employee employee = new Employee();
        employee.setFirstName("Rupesh");
        employee.setLastName("Deshmukh");
        employee.setSalaryCode(50002530);

        return employee;
    }

    /**
     * Update employee.
     * 
     * @param employee
     *            <code>net.atos.spring.training.example10.dto.Employee</code>.
     * @return <code>net.atos.spring.training.example10.dto.Employee</code>.
     */
    private static Employee updateEmployee(final Employee employee) {

        employee.setFirstName("Ramesh");
        employee.setLastName("Deshpande");
        employee.setSalaryCode(2531);

        return employee;
    }

}
