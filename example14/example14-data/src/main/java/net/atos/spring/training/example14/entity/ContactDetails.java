/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example14.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Data Transfer Object for Employee contact details.
 * 
 * @author Rupesh Deshmukh
 */
@Entity
@Table(name = "contact_details")
public class ContactDetails implements Serializable {

    /**
     * Generated serial version ID.
     */
    private static final long serialVersionUID = -1277499404238871383L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @OneToMany(mappedBy = "contactDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> addresses;

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
     * Getter for emailAddress.
     * 
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Setter for emailAddress.
     * 
     * @param emailAddress
     *            the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Getter for mobileNumber.
     * 
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    /**
     * Setter for mobileNumber.
     * 
     * @param mobileNumber
     *            the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Getter for addresses.
     * 
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return this.addresses;
    }

    /**
     * Setter for addresses.
     * 
     * @param addresses
     *            the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ContactDetails [emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber + ", addresses=" + addresses + "]";
    }

}
