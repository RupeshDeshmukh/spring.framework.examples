/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example4.type3;

/**
 * Factory class for
 * <code>net.atos.spring.training.example4.type3.TransportService</code>.
 * 
 * @author Rupesh Deshmukh
 */
public class TransportServiceFactory {

    /**
     * Factory method to create
     * <code>net.atos.spring.training.example4.type3.Car</code> instance of
     * transport service.
     * 
     * @return <code>net.atos.spring.training.example4.type3.TransportService</code>
     *         .
     */
    public TransportService createCarInstance() {
        return new Car();
    }

    /**
     * Factory method to create
     * <code>net.atos.spring.training.example4.type3.Bus</code> instance of
     * transport service.
     * 
     * @return <code>net.atos.spring.training.example4.type3.TransportService</code>
     *         .
     */
    public TransportService createBusInstance() {
        return new Bus();
    }
}
