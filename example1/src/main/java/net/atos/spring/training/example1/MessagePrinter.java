/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
     * Message service instance that will be auto-wired by spring.
     */
    private MessageService messageService;

    /**
     * Getter for messageService.
     * 
     * @return the messageService
     */
    public MessageService getMessageService() {
        return this.messageService;
    }

    /**
     * Setter for messageService.
     * 
     * @param messageService
     *            the messageService to set
     */
    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Method to print message provided by message service.
     */
    public void printMessage() {
        LOGGER.info(this.getMessageService().getMessage());
    }
}
