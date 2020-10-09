/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Stand-alone main program for executing the
 * <em>Example 9 - Spring AOP using Java Configuration</em>.
 * 
 * Here we are using @EnableAspectJAutoProxy to enable support for handling
 * components marked with @Aspect annotation.
 * 
 * @author Rupesh Deshmukh
 */
@Configuration
@EnableAspectJAutoProxy
public class Example9 {

    /**
     * The method to register
     * <code>net.atos.spring.training.example9.StudentServiceImpl</code>
     * instance returned as a bean in Spring application context.
     * 
     * @return <code>net.atos.spring.training.example9.StudentService</code>.
     */
    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    /**
     * The method to register
     * <code>net.atos.spring.training.example9.LoggingInterceptor</code>
     * instance returned as a bean in Spring application context.
     * 
     * @return <code>net.atos.spring.training.example9.LoggingInterceptor</code>
     *         .
     */
    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

    /**
     * The method to register
     * <code>net.atos.spring.training.example9.PerformanceMetrics</code>
     * instance returned as a bean in Spring application context.
     * 
     * @return <code>net.atos.spring.training.example9.PerformanceMetrics</code>
     *         .
     */
    @Bean
    public PerformanceMetrics performanceMetrics() {
        return new PerformanceMetrics();
    }

    /**
     * Main method for execution of example 8.
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
        final ApplicationContext context = new AnnotationConfigApplicationContext(Example9.class);

        /*
         * Once application context we are ready to fetch beans from the
         * context.
         */
        final Student student = new Student();
        student.setFirstName("Rupesh");
        student.setLastName("Deshmukh");
        student.setAge(31);

        final StudentService studentService = context.getBean(StudentService.class);
        studentService.saveStudent(student);

        /*
         * Finally we close the application context to avoid leaks within
         * application.
         */
        ((ConfigurableApplicationContext) context).close();
    }
}
