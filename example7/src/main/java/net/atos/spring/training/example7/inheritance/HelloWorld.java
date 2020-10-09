/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example7.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HelloWorld parent class.
 * 
 * @author Rupesh Deshmukh
 */
public class HelloWorld {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    private String message1;
    private String message2;

    /**
     * Setter for message1.
     * 
     * @param message1
     *            the message1 to set
     */
    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    /**
     * Setter for message2.
     * 
     * @param message2
     *            the message2 to set
     */
    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    /**
     * Getter for message1.
     * 
     * @return the message1
     */
    public void getMessage1() {
        LOGGER.info("World Message1 : " + this.message1);
    }

    /**
     * Getter for message2.
     * 
     * @return the message2
     */
    public void getMessage2() {
        LOGGER.info("World Message1 : " + this.message2);
    }

}
