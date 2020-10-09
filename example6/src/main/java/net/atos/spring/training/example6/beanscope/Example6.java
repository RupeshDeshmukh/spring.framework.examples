/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example6.beanscope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Stand-alone main program for executing the <em>Example 6 - Hello
 * World</em>. This example demonstrate bean scopes "singleton" and "prototype".
 * 
 * @author Rupesh Deshmukh
 */
public class Example6 {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example6.class);

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
         * LOGGER.info("============= Singleton Example ======================"
         * ); final SingletonScope singletonScope1 = (SingletonScope)
         * context.getBean("singletonScope"); LOGGER.info(
         * "I am singleton and my message is: " + singletonScope1.getMessage());
         * singletonScope1.setMessage("Hello Universe !!!"); final
         * SingletonScope singletonScope2 = (SingletonScope)
         * context.getBean("singletonScope"); LOGGER.info(
         * "I am singleton and my message is: " + singletonScope2.getMessage());
         */
        LOGGER.info("============= Prototype Example ======================");
        final PrototypeScope prototypeScope1 = (PrototypeScope) context.getBean("prototypeScope");
        LOGGER.info("I am prototype and my message is: " + prototypeScope1.getMessage());
        prototypeScope1.setMessage("Hello Universe !!!");
        final PrototypeScope prototypeScope2 = (PrototypeScope) context.getBean("prototypeScope");
        LOGGER.info("I am prototype and my message is: " + prototypeScope2.getMessage());

        /*
         * Finally we close the application context to avoid leaks within
         * application.
         */
        ((ConfigurableApplicationContext) context).close();
    }
}
