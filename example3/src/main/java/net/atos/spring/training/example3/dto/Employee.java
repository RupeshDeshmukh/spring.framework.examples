/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example3.dto;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

/**
 * Data Transfer Object for Employee data.
 * 
 * @author Rupesh Deshmukh
 */
public class Employee implements Serializable {

    /**
     * Generated serial version ID.
     */
    private static final long serialVersionUID = 8253994562380577530L;
    private int id;
    private String firstName;
    private String lastName;
    private int salaryCode;
    private ContactDetails contactDetails;
    private Map<Integer, String> projects;
    private Properties customProperties;

    /**
     * Getter for id.
     * 
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter for id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for firstName.
     * 
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for firstName.
     * 
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName.
     * 
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter for lastName.
     * 
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for salaryCode.
     * 
     * @return the salaryCode
     */
    public int getSalaryCode() {
        return this.salaryCode;
    }

    /**
     * Setter for salaryCode.
     * 
     * @param salaryCode
     *            the salaryCode to set
     */
    public void setSalaryCode(int salaryCode) {
        this.salaryCode = salaryCode;
    }

    /**
     * Getter for contactDetails.
     * 
     * @return the contactDetails
     */
    public ContactDetails getContactDetails() {
        return this.contactDetails;
    }

    /**
     * Setter for contactDetails.
     * 
     * @param contactDetails
     *            the contactDetails to set
     */
    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * Getter for projects.
     * 
     * @return the projects
     */
    public Map<Integer, String> getProjects() {
        return this.projects;
    }

    /**
     * Setter for projects.
     * 
     * @param projects
     *            the projects to set
     */
    public void setProjects(Map<Integer, String> projects) {
        this.projects = projects;
    }

    /**
     * Getter for customProperties.
     * 
     * @return the customProperties
     */
    public Properties getCustomProperties() {
        return this.customProperties;
    }

    /**
     * Setter for customProperties.
     * 
     * @param customProperties
     *            the customProperties to set
     */
    public void setCustomProperties(Properties customProperties) {
        this.customProperties = customProperties;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salaryCode=" + salaryCode + ", contactDetails="
                        + contactDetails + ", projects=" + projects + ", customProperties=" + customProperties + "]";
    }

}
