/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example14.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Data Transfer Object for Employee Address.
 * 
 * @author Rupesh Deshmukh
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -3481404797958505217L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "line1", nullable = false)
    private String line1;

    @Column(name = "line2", nullable = false)
    private String line2;

    @Column(name = "line3", nullable = true)
    private String line3;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ContactDetails contactDetails;

    public enum AddressType {
        PERMANENT, CORRESPONDCE, OFFICE
    }

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
     * Getter for line1.
     * 
     * @return the line1
     */
    public String getLine1() {
        return this.line1;
    }

    /**
     * Setter for line1.
     * 
     * @param line1
     *            the line1 to set
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     * Getter for line2.
     * 
     * @return the line2
     */
    public String getLine2() {
        return this.line2;
    }

    /**
     * Setter for line2.
     * 
     * @param line2
     *            the line2 to set
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * Getter for line3.
     * 
     * @return the line3
     */
    public String getLine3() {
        return this.line3;
    }

    /**
     * Setter for line3.
     * 
     * @param line3
     *            the line3 to set
     */
    public void setLine3(String line3) {
        this.line3 = line3;
    }

    /**
     * Getter for city.
     * 
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Setter for city.
     * 
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for state.
     * 
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Setter for state.
     * 
     * @param state
     *            the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for zipCode.
     * 
     * @return the zipCode
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * Setter for zipCode.
     * 
     * @param zipCode
     *            the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Getter for addressType.
     * 
     * @return the addressType
     */
    public AddressType getAddressType() {
        return this.addressType;
    }

    /**
     * Setter for addressType.
     * 
     * @param addressType
     *            the addressType to set
     */
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Address [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", city=" + city + ", state=" + state + ", zipCode="
                        + zipCode + ", addressType=" + addressType + "]";
    }

}
