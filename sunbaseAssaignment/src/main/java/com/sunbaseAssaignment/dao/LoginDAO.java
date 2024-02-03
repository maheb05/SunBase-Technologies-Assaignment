package com.sunbaseAssaignment.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.sunbaseAssaignment.entity.AdminEntity;
import com.sunbaseAssaignment.entity.CustomerEntity;

// Interface defining methods for login-related data access
public interface LoginDAO {

    // Method to retrieve an AdminEntity by email from the database
    // Throws EntityNotFoundException if the entity is not found
    AdminEntity getEntityByEmail(String email) throws EntityNotFoundException;

    // Method to retrieve a list of all customers from the database
    List<CustomerEntity> getAllCustomersList();
}
