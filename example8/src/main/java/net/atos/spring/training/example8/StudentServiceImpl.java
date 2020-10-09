/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example8;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example8.StudentService</code>.
 * 
 * @author Rupesh Deshmukh
 */
public class StudentServiceImpl implements StudentService {

    /**
     * {@inheritDoc}
     */
    public Student saveStudent(final Student newStudent) {

        // Write logic to save student information to database.
        newStudent.setId(1);

        for (int i = 0; i < 1000000; i++) {
            // Do nothing :-)
        }

        return newStudent;
    }
}
