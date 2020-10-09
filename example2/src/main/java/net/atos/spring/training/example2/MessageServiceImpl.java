/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example2;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example1.MessageService</code>.
 * 
 * @author Rupesh Deshmukh
 */
public class MessageServiceImpl implements MessageService {

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return "Hello World !!!";
    }
}
