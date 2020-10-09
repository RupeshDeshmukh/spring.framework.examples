/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example6.beanlifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HelloWorld class with bean lifecycle method init and destroy.
 * 
 * @author Rupesh Deshmukh
 */
public class HelloWorld {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    private String message;

    /**
     * Bean lifecycle method for initializing bean. The method will be called
     * immediately after spring context creates the bean.
     */
    public void init() {
        LOGGER.info("Bean is going through init.");
    }

    /**
     * Bean lifecycle method for initializing bean. The method will be called
     * immediately after spring context destroys the bean.
     */
    public void destroy() {
        LOGGER.info("Bean will destroy now.");
    }

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
