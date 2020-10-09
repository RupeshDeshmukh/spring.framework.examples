/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import net.atos.spring.training.example14.dto.EmployeeSearch;
import net.atos.spring.training.example14.entity.Employee;
import net.atos.spring.training.example14.service.EmployeeService;
import net.atos.spring.training.example14.validator.EmployeeValidator;

/**
 * Spring controller for employee search screen.
 * 
 * @author Rupesh Deshmukh
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeValidator employeeValidator;

    /**
     * Method to prepare the model to be binded and displayed in employee search
     * screen.
     * 
     * @param model
     *            <code>org.springframework.ui.Model</code>.
     * @return String navigation string to exact employee page.
     */
    @RequestMapping("/employee")
    public String displayEmployeeSearchPage(final Model model) {

        final EmployeeSearch employeeSearch = new EmployeeSearch();
        model.addAttribute("employeeSearch", employeeSearch);

        return "employeeSearch";
    }

    /**
     * Method invoke service layer to search employees based on the criteria
     * entered by the user.
     * 
     * @param employeeSearch
     *            <code>net.atos.spring.training.example14.dto.EmployeeSearch</code>
     *            .
     * @param model
     *            <code>org.springframework.ui.Model</code>.
     * @return String navigation string to exact employee page.
     */
    @RequestMapping(value = "/employee/search", method = RequestMethod.POST)
    public String searchEmployeesByCriteria(@ModelAttribute final EmployeeSearch employeeSearch, final Model model) {

        final List<Employee> employeeSearchResult = this.employeeService.findEmployeesBySearchCriteria(employeeSearch);
        model.addAttribute("employees", employeeSearchResult);

        return "employeeSearch";
    }

    /**
     * Method to prepare the model to be binded and displayed in employee add
     * screen.
     * 
     * @param model
     *            <code>org.springframework.ui.Model</code>.
     * @return String navigation string to exact employee page.
     */
    @RequestMapping("/employee/addform")
    public String addNewEmployeeForm(final Model model) {

        final Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "addEmployee";
    }

    /**
     * Method invoke service layer to add employee based on the details entered
     * by the user.
     * 
     * @param employee
     *            <code>net.atos.spring.training.example14.entity.Employee</code>
     *            .
     * @param result
     *            <code>org.springframework.validation.BindingResult</code>.
     * @param status
     *            <code>org.springframework.validation.SessionStatus</code>.
     * @return String navigation string to exact employee page.
     */
    @RequestMapping("/employee/add")
    public String addEmployee(@ModelAttribute final Employee employee, final BindingResult result, final SessionStatus status) {

        // Perform server side validation for entered values.
        this.getEmployeeValidator().validate(employee, result);

        // If there are errors return back to same page to show errors to the
        // user.
        if (result.hasErrors()) {
            return "addEmployee";
        }

        this.getEmployeeService().create(employee);

        return "addEmployee";
    }

    /**
     * Getter for employeeService.
     * 
     * @return the employeeService
     */
    public EmployeeService getEmployeeService() {
        return this.employeeService;
    }

    /**
     * Setter for employeeService.
     * 
     * @param employeeService
     *            the employeeService to set
     */
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Getter for employeeValidator.
     * 
     * @return the employeeValidator
     */
    public EmployeeValidator getEmployeeValidator() {
        return employeeValidator;
    }

    /**
     * Setter for employeeValidator.
     * 
     * @param employeeValidator
     *            the employeeValidator to set
     */
    public void setEmployeeValidator(EmployeeValidator employeeValidator) {
        this.employeeValidator = employeeValidator;
    }

}
