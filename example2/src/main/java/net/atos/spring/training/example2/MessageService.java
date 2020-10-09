/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example2;

/**
 * Message service with operations to manage message flow.
 * 
 * @author Rupesh Deshmukh
 */
public interface MessageService {

    /**
     * To return message to the caller.
     * 
     * @return String message.
     */
    String getMessage();
}
