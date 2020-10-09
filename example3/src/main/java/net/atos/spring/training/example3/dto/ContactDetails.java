/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example3.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Data Transfer Object for Employee contact details.
 * 
 * @author Rupesh Deshmukh
 */
public class ContactDetails implements Serializable {

    /**
     * Generated serial version ID.
     */
    private static final long serialVersionUID = -1882277971429693427L;
    private String emailAddress;
    private String mobileNumber;
    private List<Address> addresses;

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
