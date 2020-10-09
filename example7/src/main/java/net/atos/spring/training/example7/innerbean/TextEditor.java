/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example7.innerbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TextEditor to be defined as outer bean.
 * 
 * @author Rupesh Deshmukh
 */
public class TextEditor {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TextEditor.class);

    private SpellChecker spellChecker;

    /**
     * Setter for spellChecker.
     * 
     * @param spellChecker
     */
    public void setSpellChecker(final SpellChecker spellChecker) {

        LOGGER.info("Inside setSpellChecker.");

        this.spellChecker = spellChecker;
    }

    /**
     * Getter for spellChecker.
     * 
     * @return the spellChecker
     */
    public SpellChecker getSpellChecker() {
        return this.spellChecker;
    }

    /**
     * Method to invoke spell check.
     */
    public void spellCheck() {
        this.getSpellChecker().checkSpelling();
    }

}
