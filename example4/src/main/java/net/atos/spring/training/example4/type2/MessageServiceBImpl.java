/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example4.type2;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example4.type2.MessageService</code>.
 * 
 * @author Rupesh Deshmukh
 */
public class MessageServiceBImpl implements MessageService {

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return "Hello World !!! - Message from Message Service B";
    }
}
