/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example5.bytype;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example5.MessageService</code>.
 * 
 * @author Rupesh Deshmukh
 */
public class MessageServiceImpl implements MessageService {

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return "Hello User !!! You have managed to demonstrate autowiring using byType";
    }
}
