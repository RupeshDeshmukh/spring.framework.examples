/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example6.beanscope;

/**
 * Simple POJO to demonstrate bean scope "singleton".
 * 
 * @author Rupesh Deshmukh
 */
public class SingletonScope {

    private String message;

    /**
     * Getter for message.
     * 
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Setter for message.
     * 
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
