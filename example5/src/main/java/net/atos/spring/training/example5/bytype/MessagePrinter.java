/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example5.bytype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Message printer that uses fetches messages from
 * <code>net.atos.spring.training.example5.MessageService</code> and print it on
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
     * Message service instance that will be autowired by spring byName.
     */
    private MessageService service;

    /**
     * Method to print message provided by message service.
     */
    public void printMessage() {
        LOGGER.info(this.getService().getMessage());
    }

    /**
     * Getter for service.
     * 
     * @return the service
     */
    public MessageService getService() {
        return service;
    }

    /**
     * Setter for service.
     * 
     * @param service
     *            the service to set
     */
    public void setService(MessageService service) {
        this.service = service;
    }

}
