package com.sunbaseAssaignment.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunbaseAssaignment.dao.LoginDAO;
import com.sunbaseAssaignment.entity.AdminEntity;
import com.sunbaseAssaignment.entity.CustomerEntity;
import com.sunbaseAssaignment.exception.InvalidCredintialsExceptions;

/**
 * The {@code LoginService} class provides business logic related to user authentication and access control.
 */
@Component
public class LoginService {

    private LoginDAO loginDAO;

    /**
     * Default constructor for LoginService.
     */
    public LoginService() {
        System.out.println("Default Login Service");
    }

    /**
     * Constructs a new instance of {@code LoginService} with the specified LoginDAO.
     *
     * @param loginDAO The data access object for user authentication.
     */
    @Autowired
    public LoginService(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    /**
     * Validates user credentials.
     *
     * @param email    The user's email.
     * @param password The user's password.
     * @return True if the credentials are valid, false otherwise.
     * @throws InvalidCredintialsExceptions If the provided credentials are invalid.
     */
    public boolean validateCredentials(String email, String password)
            throws InvalidCredintialsExceptions, EntityNotFoundException {
        boolean flag = true;

        if (email == null || email.isBlank() || email.isEmpty()) {
            flag = false;
            throw new InvalidCredintialsExceptions("Please enter valid email");
        }

        if (password == null || password.isEmpty() || password.isBlank()) {
            flag = false;
            throw new InvalidCredintialsExceptions("please enter valid password");
        }
        return flag;
    }

    /**
     * Retrieves an AdminEntity by email and validates the provided password.
     *
     * @param email    The email of the AdminEntity.
     * @param password The password to validate.
     * @return True if the authentication is successful, false otherwise.
     * @throws InvalidCredintialsExceptions If the provided credentials are invalid.
     */
    public boolean getAdminEntityByEmail(String email, String password) throws InvalidCredintialsExceptions {
        boolean credentials = validateCredentials(email, password);
        if (credentials) {
            AdminEntity entity = loginDAO.getEntityByEmail(email);
            System.out.println("service entity" + entity);
            if (entity != null) {
                if (entity.getPassword().equals(password)) {
                    System.out.println("password matched in service");
                    return true;
                } else {
                    System.out.println("password not matched in service");
                    throw new InvalidCredintialsExceptions("Incorrect Password please check and try again");
                }
            } else {
                System.out.println("entity is null at service login");
                throw new InvalidCredintialsExceptions("Email Doesn't exist please check your email");
            }
        } else {
            return false;
        }
    }

    /**
     * Retrieves an AdminEntity by email.
     *
     * @param email The email of the AdminEntity.
     * @return The AdminEntity corresponding to the given email.
     * @throws EntityNotFoundException If no AdminEntity is found with the provided email.
     */
    public AdminEntity getEntityByEmail(String email) throws EntityNotFoundException {
        return loginDAO.getEntityByEmail(email);
    }

    /**
     * Retrieves a list of all CustomerEntities.
     *
     * @return List of CustomerEntities.
     */
    public List<CustomerEntity> getAllCustomerList() {
        return loginDAO.getAllCustomersList();
    }
}
