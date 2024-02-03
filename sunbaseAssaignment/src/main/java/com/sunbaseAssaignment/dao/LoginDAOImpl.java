package com.sunbaseAssaignment.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunbaseAssaignment.entity.AdminEntity;
import com.sunbaseAssaignment.entity.CustomerEntity;

// Implementation class for LoginDAO, responsible for database operations related to login and customer entities
@Component
public class LoginDAOImpl implements LoginDAO {

    // SessionFactory for managing Hibernate sessions
    private SessionFactory sessionFactory;

    // Default constructor (no-arg) for the DAO
    public LoginDAOImpl() {
        System.out.println("Default LoginDAOImpl");
    }

    // Constructor with autowired SessionFactory
    @Autowired
    public LoginDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to retrieve an AdminEntity by email from the database
    // Throws EntityNotFoundException if the entity is not found
    @Override
    public AdminEntity getEntityByEmail(String email) throws EntityNotFoundException {
        Session session = null;
        AdminEntity entity = null;
        String GET_QUERY = "from AdminEntity ae where ae.email=:email";
        try {
            // Open a new session
            session = sessionFactory.openSession();

            // Create HQL query to retrieve AdminEntity by email
            Query<AdminEntity> query = session.createQuery(GET_QUERY, AdminEntity.class);
            query.setParameter("email", email);
            entity = query.uniqueResult();

            // Check if AdminEntity exists
            if (entity != null) {
                return entity;
            } else {
                throw new EntityNotFoundException("No Admin Found with this email " + email);
            }
        } catch (HibernateException e) {
            // Catch and rethrow HibernateException as EntityNotFoundException
            throw new EntityNotFoundException("Exception in getting AdminEntityByEmail " + e.getMessage());
        } finally {
            // Close the session
            if (session != null) {
                session.close();
            }
        }
    }

    // Method to retrieve a list of all customers from the database
    @Override
    public List<CustomerEntity> getAllCustomersList() {
        Session session = null;
        List<CustomerEntity> resultList = null;
        try {
            // Open a new session
            session = sessionFactory.openSession();

            // Create HQL query to retrieve all CustomerEntity records
            Query<CustomerEntity> query = session.createQuery("from CustomerEntity ");
            resultList = query.getResultList();

            return resultList;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            // Close the session
            if (session != null) {
                session.close();
            }
        }
        return resultList;
    }
}
