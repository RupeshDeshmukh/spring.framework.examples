/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example5.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Stand-alone main program for executing the <em>Example 5 - Hello
 * World</em>. This example demonstrate autowiring constructor feature of
 * Spring.
 * 
 * @author Rupesh Deshmukh
 */
public class Example5 {

    /**
     * Main method for execution of example 2.
     * 
     * @param args
     *            String[]
     */
    public static void main(final String[] args) {

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
         * to scan XML based spring configuration and peform application wiring.
         */
        final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        /*
         * Once application context we are ready to fetch beans from the
         * context. Here in this case application context will create instance
         * of MessagePrinter.
         */
        final MessagePrinter printer = (MessagePrinter) context.getBean("messagePrinterByConstructor");

        /*
         * Once we get instance of MessagePrinter we can print the message sent
         * by MessageService.
         */
        printer.printMessage();

        /*
         * Finally we close the application context to avoid leaks within
         * application.
         */
        ((ConfigurableApplicationContext) context).close();
    }
}
