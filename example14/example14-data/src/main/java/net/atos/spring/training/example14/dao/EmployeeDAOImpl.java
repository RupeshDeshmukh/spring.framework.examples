/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example14.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import net.atos.spring.training.example14.dto.EmployeeSearch;
import net.atos.spring.training.example14.entity.Employee;

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
    @Override
    @Transactional
    public Employee create(final Employee employee) {

        this.getEntityManager().persist(employee);

        return employee;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Employee read(final Integer id) {

        return this.getEntityManager().find(Employee.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(final Employee employee) {

        this.getEntityManager().merge(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(final Integer id) {

        final Employee employee = this.read(id);

        this.getEntityManager().remove(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {

        final Query query = this.getEntityManager().createQuery("from employee");

        return (List<Employee>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesBySearchCriteria(final EmployeeSearch employeeSearch) {

        final CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        final Root<Employee> employee = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employee);

        final List<Predicate> predicateList = new ArrayList<Predicate>();

        Predicate firstNamePredicate, lastNamePredicate, salaryCodePredicate;

        if (!StringUtils.isEmpty(employeeSearch.getFirstName())) {
            firstNamePredicate = criteriaBuilder.like(criteriaBuilder.upper(employee.<String> get("firstName")),
                            "%" + employeeSearch.getFirstName().toUpperCase() + "%");
            predicateList.add(firstNamePredicate);
        }

        if (!StringUtils.isEmpty(employeeSearch.getLastName())) {
            lastNamePredicate = criteriaBuilder.like(criteriaBuilder.upper(employee.<String> get("lastName")),
                            "%" + employeeSearch.getLastName().toUpperCase() + "%");
            predicateList.add(lastNamePredicate);
        }

        if (employeeSearch.getSalaryCode() != null && employeeSearch.getSalaryCode() != 0) {
            salaryCodePredicate = criteriaBuilder.equal(employee.<Integer> get("salaryCode"), employeeSearch.getSalaryCode());
            predicateList.add(salaryCodePredicate);
        }

        final Predicate[] predicates = new Predicate[predicateList.size()];
        criteriaQuery.where(predicateList.toArray(predicates));

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
    @Override
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
