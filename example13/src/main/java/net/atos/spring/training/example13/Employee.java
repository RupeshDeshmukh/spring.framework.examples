/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example13;

import java.io.Serializable;

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salaryCode=" + salaryCode + "]";
    }

}
