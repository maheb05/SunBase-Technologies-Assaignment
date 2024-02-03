package com.sunbaseAssaignment.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunbaseAssaignment.entity.CustomerEntity;

// Implementation class for CustomerDAO, responsible for database operations related to CustomerEntity
@Component
public class CustomerDAOImpl implements CustomerDAO {

    // SessionFactory for managing Hibernate sessions
    private SessionFactory sessionFactory;

    // Default constructor (no-arg) for the DAO
    public CustomerDAOImpl() {
        System.out.println("Default CustomerDAOImpl");
    }

    // Constructor with autowired SessionFactory
    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to add a new member (CustomerEntity) to the database
    @Override
    public boolean addMember(CustomerEntity entity) {
        boolean flag = false;
        Session session = null;
        Transaction transaction = null;
        try {
            // Open a new session
            session = sessionFactory.openSession();

            // Begin a new transaction
            transaction = session.beginTransaction();

            // Save the CustomerEntity to the database
            session.save(entity);

            // Commit the transaction
            transaction.commit();
            flag = true;
        } catch (HibernateException e) {
            // If an exception occurs, rollback the transaction
            if (transaction != null) {
                transaction.rollback();
            }
            flag = false;
            e.printStackTrace();
        } finally {
            // Close the session
            if (session != null) {
                session.close();
            }
        }

        return flag;
    }

    // Method to retrieve a particular customer by ID from the database
    @Override
    public CustomerEntity getParticularCustomer(int id) {
        Session session = null;
        CustomerEntity customer = null;
        try {
            // Open a new session
            session = sessionFactory.openSession();

            // Create HQL query to retrieve a customer by ID
            Query<CustomerEntity> query = session.createQuery("from CustomerEntity ce where ce.id=:id", CustomerEntity.class);
            query.setParameter("id", id);

            // Get the unique result
            customer = query.uniqueResult();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the session
            if (session != null) {
                session.close();
            }
        }
        return customer;
    }

    // Method to update details of an existing member in the database
    @Override
    public boolean updateMember(CustomerEntity entity) {
        boolean flag = false;
        Session session = null;
        Transaction transaction = null;
        try {
            // Open a new session
            session = sessionFactory.openSession();

            // Begin a new transaction
            transaction = session.beginTransaction();

            // Update the CustomerEntity in the database
            session.update(entity);

            // Commit the transaction
            transaction.commit();
            flag = true;
        } catch (Exception e) {
            // If an exception occurs, rollback the transaction
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            if (session != null) {
                session.close();
            }
        }
        return flag;
    }

    // Method to delete a member by ID from the database
    @Override
    public boolean delete(int id) {
        boolean flag = false;
        Session session = null;
        Transaction transaction = null;
        try {
            // Open a new session
            session = sessionFactory.openSession();

            // Begin a new transaction
            transaction = session.beginTransaction();

            // Get the CustomerEntity by ID
            CustomerEntity entity = session.get(CustomerEntity.class, id);

            // Delete the CustomerEntity from the database
            session.delete(entity);

            // Commit the transaction
            transaction.commit();
            flag = true;
        } catch (Exception e) {
            // If an exception occurs, rollback the transaction
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            if (session != null) {
                session.close();
            }
        }
        return flag;
    }
}
