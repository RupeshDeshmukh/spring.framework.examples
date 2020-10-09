/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example4.type2;

/**
 * Factory class for
 * <code>net.atos.spring.training.example4.type2.MessageService</code>.
 * 
 * @author Rupesh Deshmukh
 */
public class MessageServiceFactory {

    /**
     * Factory method to create instance of message service.
     * 
     * @param serviceOption
     *            String to know which service to be used.
     * @return <code>net.atos.spring.training.example4.type2.MessageService</code>
     *         .
     */
    public static MessageService getMessageService(final String serviceOption) {

        if (serviceOption.equals("ServiceA")) {
            return new MessageServiceAImpl();
        } else if (serviceOption.equals("ServiceB")) {
            return new MessageServiceBImpl();
        }

        return null;
    }
}
