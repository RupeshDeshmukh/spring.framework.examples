/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example11.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.atos.spring.training.example11.entity.Employee;

/**
 * Implementation class for
 * <code>net.atos.spring.training.example10.dao.EmployeeDAO</code>.
 * 
 * @author Rupesh Deshmukh
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Transactional
    public Employee create(final Employee employee) {

        this.getEntityManager().persist(employee);

        return employee;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public Employee read(final Integer id) {

        return this.getEntityManager().find(Employee.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void update(final Employee employee) {

        this.getEntityManager().merge(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void delete(final Integer id) {

        final Employee employee = this.read(id);

        this.getEntityManager().remove(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public Employee findEmployeeBySalaryCode(final int salaryCode) {

        final Query query = this.getEntityManager().createQuery("from employee e where e.salaryCode = :salaryCode");
        query.setParameter("salaryCode", salaryCode);

        return (Employee) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {

        final Query query = this.getEntityManager().createQuery("from employee");

        return (List<Employee>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public int countEmployeesByFirstName(final String firstName) {

        final Query query = this.getEntityManager().createQuery("select count(e) from Employee e where e.firstName = :firstName");
        query.setParameter("firstName", firstName);

        final Long count = (Long) query.getSingleResult();

        return count.intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public int countEmployees(final Employee employee) {

        final Query query = this.getEntityManager().createQuery("select count(e) from Employee e where e.firstName = :firstName and e.lastName = :lastName");
        query.setParameter("firstName", employee.getFirstName());
        query.setParameter("lastName", employee.getLastName());

        final Long count = (Long) query.getSingleResult();

        return count.intValue();
    }

    /**
     * Getter for entityManager.
     * 
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     * Setter for entityManager.
     * 
     * @param entityManager
     *            the entityManager to set
     */
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
