package com.sunbaseAssaignment.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunbaseAssaignment.entity.AdminEntity;

// Implementation class for AdminDAO, responsible for database operations related to AdminEntity
@Component
public class AdminDAOImpl implements AdminDAO {

    // SessionFactory for managing Hibernate sessions
    private SessionFactory sessionFactory;

    // Constructor with autowired SessionFactory
    @Autowired
    public AdminDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Default constructor (no-arg) for the DAO
    public AdminDAOImpl() {
        System.out.println("Default AdminDAOImpl Constructor");
    }

    // Method to save an AdminEntity to the database
    public boolean saveAdminEntity(AdminEntity entity) {
        boolean flag = false;
        Session session = null;
        Transaction transaction = null;
        try {
            // Open a new session
            session = sessionFactory.openSession();

            // Begin a new transaction
            transaction = session.beginTransaction();

            // Save the AdminEntity to the database
            session.save(entity);

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
