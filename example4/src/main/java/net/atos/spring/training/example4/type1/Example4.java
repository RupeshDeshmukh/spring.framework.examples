/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example4.type1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Stand-alone main program for executing the
 * <em>Example 4 - Type 1 DI using Factory Method</em>.
 * 
 * @author Rupesh Deshmukh
 */
public class Example4 {

    /**
     * Main method for execution of example 4.
     * 
     * @param args
     *            String[]
     */
    public static void main(String[] args) {

        /*
         * The interface org.springframework.context.ApplicationContext
         * represents the Spring IoC container and is responsible for
         * instantiating, configuring, and assembling the aforementioned beans.
         * The container gets its instructions on what objects to instantiate,
         * configure, and assemble by reading configuration meta-data. The
         * configuration meta-data is represented in XML, Java annotations, or
         * Java code. It allows you to express the objects that compose your
         * application and the rich interdependencies between such objects.
         * 
         * org.springframework.context.support. ClassPathXmlApplicationContext
         * is one of the implementation of ApplicationContext that can be used
         * to scan XML based spring configuration and perform application
         * wiring.
         */
        final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        final StaticFMOwnClass staticFMOwnClass = (StaticFMOwnClass) context.getBean("staticFMOwnClass");
        staticFMOwnClass.displayMessage();

        /*
         * Finally we close the application context to avoid leaks within
         * application.
         */
        ((ConfigurableApplicationContext) context).close();

    }

}
