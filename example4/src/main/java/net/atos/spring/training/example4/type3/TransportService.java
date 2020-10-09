/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example4.type3;

/**
 * Transport service with operations to manage transport information.
 * 
 * @author Rupesh Deshmukh
 */
public interface TransportService {

    /**
     * To return available transport to the caller.
     * 
     * @return String transport.
     */
    String getTransport();
}
