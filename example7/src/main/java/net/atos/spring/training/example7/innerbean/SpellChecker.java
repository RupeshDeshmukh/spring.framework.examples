/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example7.innerbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SpellChecker inner bean.
 * 
 * @author Rupesh Deshmukh
 */
public class SpellChecker {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpellChecker.class);

    /**
     * Default constructor.
     */
    public SpellChecker() {
        LOGGER.info("Inside SpellChecker constructor.");
    }

    /**
     * Method to check spelling.
     */
    public void checkSpelling() {
        LOGGER.info("Inside checkSpelling.");
    }
}
