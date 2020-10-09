/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example8;

/**
 * POJO for Student.
 * 
 * @author Rupesh Deshmukh
 */
public class Student {

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer age;

    /**
     * Getter for id.
     * 
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
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
     * Getter for age.
     * 
     * @return the age
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * Setter for age.
     * 
     * @param age
     *            the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
    }

}
