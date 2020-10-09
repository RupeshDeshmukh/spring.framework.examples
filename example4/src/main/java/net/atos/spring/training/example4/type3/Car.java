/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example4.type3;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example4.type3.TransportService</code>.
 * 
 * @author Rupesh Deshmukh
 */
public class Car implements TransportService {

    /**
     * {@inheritDoc}
     */
    public String getTransport() {
        return "Hello User !!! - Todays Transport mode is Car. Enjoy your ride !!!";
    }

}
