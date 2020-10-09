/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example3;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import net.atos.spring.training.example3.dto.Employee;
import net.atos.spring.training.example3.dto.SearchCriteria;
import net.atos.spring.training.example3.service.EmployeeService;

/**
 * Stand-alone main program for executing the
 * <em>Example 3 - DI using Constructor & Setter</em>. This example demonstrate
 * following:
 * 
 * <ol>
 * <li>Basic example of Dependency Injection using constructor.</li>
 * <li>Basic example of Dependency Injection using setters.</li>
 * <li>Managing collections using list, set, map and props in Spring
 * configuration file.</li>
 * <li>Some flavor of Java 8 lambda expression.</li>
 * </ol>
 * 
 * @author Rupesh Deshmukh
 */
public class Example3 {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example3.class);

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

        // Prepare the search criteria object for performing search.
        final SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setLastName("Deshmukh");

        // Fetch the employee service instance using spring context.
        final EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        // Search employee by passing search criteria object to employee search
        // service.
        final Set<Employee> employees = employeeService.searchEmployee(searchCriteria);

        if (CollectionUtils.isEmpty(employees)) {
            LOGGER.info("No employee found for the search criteria: " + searchCriteria.toString());
        } else {
            LOGGER.info("Number of employees found: " + employees.size());
            LOGGER.info("Search Results:");
            employees.stream().forEach(e -> LOGGER.info(e.toString()));
        }

        /*
         * Finally we close the application context to avoid leaks within
         * application.
         */
        ((ConfigurableApplicationContext) context).close();
    }

}
