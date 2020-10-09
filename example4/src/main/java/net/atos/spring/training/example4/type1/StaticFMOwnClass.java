/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example4.type1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to demonstrate Static Factory Method returning instance of its own
 * class. Here we are using Eager Singleton mechanism to create instance of
 * class.
 * 
 * @author Rupesh Deshmukh
 */
public class StaticFMOwnClass {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StaticFMOwnClass.class);

    /**
     * Singleton instance of the class created when class is loaded.
     */
    private static StaticFMOwnClass instance = new StaticFMOwnClass();

    /**
     * Private constructor to avoid creation of instance outside this class. It
     * also throws InstantiationErrorto avoid creation of new instance using
     * reflection.
     */
    private StaticFMOwnClass() {

        LOGGER.info("In private constructor - Initializing the singleton instance.");

        if (StaticFMOwnClass.instance != null) {
            throw new InstantiationError("Cannot create instance Singleton through reflection");
        }
    }

    /**
     * This method prevents creating multiple instances of this class during
     * deserialization process.
     * 
     * @return <code>net.atos.spring.training.example4.StaticFMOwnClass</code>.
     */
    protected Object readResolve() {
        return StaticFMOwnClass.instance;
    }

    /**
     * Factory Method to return instance of its own class.
     * 
     * @return <code>net.atos.spring.training.example4.StaticFMOwnClass</code>.
     */
    public static StaticFMOwnClass getInstance() {

        LOGGER.info("In factory method - Returning the singleton instance.");

        return StaticFMOwnClass.instance;
    }

    /**
     * Method to display message to the user.
     */
    public void displayMessage() {

        LOGGER.info("Hello, you have just demonstrated Type 1 - DI using Factory Method.");
    }
}
