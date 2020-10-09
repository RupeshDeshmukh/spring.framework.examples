package net.atos.spring.training.example11;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.atos.spring.training.example11.entity.Address;
import net.atos.spring.training.example11.entity.Address.AddressType;
import net.atos.spring.training.example11.entity.ContactDetails;
import net.atos.spring.training.example11.entity.Employee;
import net.atos.spring.training.example11.service.EmployeeService;

/**
 * Stand-alone main program for executing the
 * <em>Example 11 - Spring ORM with JPA & Hibernate</em>.
 * 
 * @author Rupesh Deshmukh
 */
public class Example11 {

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
        //employeeService.create(createEmployee());

        // Read the existing.
        //final Employee employee = employeeService.read(1);

        // Update the existing employee details.
        //employeeService.update(updateEmployee(employee));

        // Delete the employee.
        //employeeService.delete(1);

        // Count employees based on first name.
        //employeeService.countEmployeesByFirstName("Rupesh");

        // Count employees based on employee details.
        final Employee employee = new Employee();
        employee.setFirstName("Rupesh");
        employee.setLastName("Deshmukh");
        employeeService.countEmployees(employee);

        /*
         * Finally we close the application context to avoid leaks within
         * application.
         */
        ((ConfigurableApplicationContext) context).close();
    }

    /**
     * Create employee.
     * 
     * @return <code>net.atos.spring.training.example11.entity.Employee</code>.
     */
    private static Employee createEmployee() {

        final Employee employee = new Employee();

        employee.setFirstName("Rupesh");
        employee.setLastName("Deshmukh");
        employee.setSalaryCode(2530);
        employee.setContactDetails(createContactDetails());

        return employee;
    }

    /**
     * Create contact details for the employee.
     * 
     * @return <code>net.atos.spring.training.example11.entity.ContactDetails</code>
     *         .
     */
    private static ContactDetails createContactDetails() {

        final ContactDetails contactDetails = new ContactDetails();

        contactDetails.setEmailAddress("rupesh.deshmukh@atos.net");
        contactDetails.setMobileNumber("9833049266");

        final List<Address> addresses = new ArrayList<Address>();
        addresses.add(createAddress(contactDetails));

        contactDetails.setAddresses(addresses);

        return contactDetails;
    }

    /**
     * Create address details for the employee.
     * 
     * @return <code>net.atos.spring.training.example11.entity.Address</code> .
     */
    private static Address createAddress(final ContactDetails contactDetails) {

        final Address address = new Address();

        address.setLine1("Rajiv Gandhi Info Tech Park");
        address.setLine2("Embassy Tech Zone");
        address.setLine3("Block 1.6, MIDC Phase II, Hinjwadi");
        address.setCity("Pune");
        address.setState("Maharashtra");
        address.setZipCode("411057");
        address.setAddressType(AddressType.OFFICE);
        address.setContactDetails(contactDetails);

        return address;
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
