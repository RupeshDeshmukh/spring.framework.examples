/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example1;

import org.springframework.stereotype.Component;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example1.MessageService</code>.
 * 
 * @author Rupesh Deshmukh
 */
@Component
public class MessageServiceImpl implements MessageService {

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return "Hello World Apprentice to Spring";
    }
}
