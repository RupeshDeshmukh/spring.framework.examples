/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example11.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Data Transfer Object for Employee data.
 * 
 * @author Rupesh Deshmukh
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -5903299397004480021L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "salary_code", nullable = false)
    private int salaryCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ContactDetails contactDetails;

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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salaryCode=" + salaryCode + ", contactDetails="
                        + contactDetails + "]";
    }
}
