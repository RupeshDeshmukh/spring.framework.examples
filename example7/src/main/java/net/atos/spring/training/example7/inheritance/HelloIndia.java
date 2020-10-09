/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example7.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HelloIndia child class.
 * 
 * @author Rupesh Deshmukh
 */
public class HelloIndia {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloIndia.class);

    private String message1;
    private String message2;
    private String message3;

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
     * Setter for message3.
     * 
     * @param message3
     *            the message3 to set
     */
    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    /**
     * Getter for message1.
     * 
     * @return the message1
     */
    public void getMessage1() {
        LOGGER.info("India Message1 : " + this.message1);
    }

    /**
     * Getter for message2.
     * 
     * @return the message2
     */
    public void getMessage2() {
        LOGGER.info("India Message2 : " + this.message2);
    }

    /**
     * Getter for message3.
     * 
     * @return the message3
     */
    public void getMessage3() {
        LOGGER.info("India Message3 : " + this.message3);
    }

}
