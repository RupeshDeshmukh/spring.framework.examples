/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example14.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.spring.training.example14.entity.Employee;

/**
 * Custom validator for validating employee information.
 * 
 * @author Rupesh Deshmukh
 */
@Component
public class EmployeeValidator implements Validator {

    /**
     * {@inheritDoc}
     */
    public boolean supports(Class clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    /**
     * {@inheritDoc}
     */
    public void validate(final Object target, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salaryCode", "error.salaryCode", "Salary Code is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactDetails.emailAddress", "error.emailAddress", "Email Address is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactDetails.mobileNumber", "error.mobileNumber", "Mobile Number is required.");
    }
}
