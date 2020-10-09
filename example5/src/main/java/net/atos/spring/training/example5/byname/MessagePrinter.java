/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example5.byname;

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
    private MessageService messageServiceByName;

    /**
     * Method to print message provided by message service.
     */
    public void printMessage() {
        LOGGER.info(this.getMessageServiceByName().getMessage());
    }

    /**
     * Getter for messageServiceByName.
     * 
     * @return the messageServiceByName
     */
    public MessageService getMessageServiceByName() {
        return this.messageServiceByName;
    }

    /**
     * Setter for messageServiceByName.
     * 
     * @param messageServiceByName
     *            the messageServiceByName to set
     */
    public void setMessageServiceByName(MessageService messageServiceByName) {
        this.messageServiceByName = messageServiceByName;
    }

}
