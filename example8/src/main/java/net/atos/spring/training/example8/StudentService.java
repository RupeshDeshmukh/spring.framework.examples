/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example8;

/**
 * Service managing student information.
 * 
 * @author Rupesh Deshmukh
 */
public interface StudentService {

    /**
     * Method to save the new student information.
     * 
     * @param newStudent
     *            <code>net.atos.spring.training.example8.Student</code>.
     * @return <code>net.atos.spring.training.example8.Student</code>.
     */
    Student saveStudent(final Student newStudent);
}
