/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example3.dto;

import java.io.Serializable;

/**
 * Data Transfer Object for Employee Address.
 * 
 * @author Rupesh Deshmukh
 */
public class Address implements Serializable {

    /**
     * Generated serial version ID.
     */
    private static final long serialVersionUID = -8723495096181849750L;
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String state;
    private String zipCode;
    private AddressType addressType;

    public enum AddressType {
        PERMANENT, CORRESPONDCE, OFFICE
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Address [line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
                        + ", addressType=" + addressType + "]";
    }

}
