/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example5.constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Message printer that uses fetches messages from
 * <code>net.atos.spring.training.example1.MessageService</code> and print it on
 * console.
 * 
 * @author Rupesh Deshmukh
 */
public class MessagePrinter {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MessagePrinter.class);

    /**
     * Message service instance that will be initialized by spring using
     * constructor injection.
     */
    private MessageService service;

    /**
     * Constructor demonstrating dependency injection feature of Spring. Using
     * constructor to inject dependency is typically called as <b>Constructor
     * Injection</b>.
     * 
     * @param service
     *            <code>net.atos.spring.training.example1.MessageService</code>.
     */
    public MessagePrinter(final MessageService service) {
        this.service = service;
    }

    /**
     * Method to print message provided by message service.
     */
    public void printMessage() {
        LOGGER.info(this.service.getMessage());
    }
}
