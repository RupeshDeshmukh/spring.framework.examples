/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Stand-alone main program for executing the <em>Example 1 - Hello
 * World</em>. This example demonstrate following:
 * 
 * <ol>
 * <li>Spring Framework Maven Dependency Configuration</li>
 * <li>Basic example of Java based configuration of spring application.
 * </li>
 * <li>Basic example of IoC and Dependency Injection.</li>
 * </ol>
 * 
 * @author Rupesh Deshmukh
 */
@Configuration
@ComponentScan
public class Example1 {

    /**
     * The method to register
     * <code>net.atos.spring.training.example1.MessagePrinter</code> instance
     * returned as a bean in Spring application context.
     * 
     * @return <code>net.atos.spring.training.example1.MessagePrinter</code>.
     */
    @Bean
    public MessagePrinter messagePrinter() {
        return new MessagePrinter();
    }

    /**
     * Main method for execution of example 1.
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
         * org.springframework.context.annotation.
         * AnnotationConfigApplicationContext is one of the implementation of
         * ApplicationContext that can be used to scan annotated classes
         * especially @Configuration.
         */
        final ApplicationContext context = new AnnotationConfigApplicationContext(Example1.class);

        /*
         * Once application context we are ready to fetch beans from the
         * context. Here in this case application context will create instance
         * of MessagePrinter.
         */
        final MessagePrinter printer = context.getBean(MessagePrinter.class);

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
