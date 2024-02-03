package com.sunbaseAssaignment.dao;

import com.sunbaseAssaignment.entity.CustomerEntity;

// Interface defining methods for CustomerEntity data access
public interface CustomerDAO {

    // Method to add a new member (CustomerEntity) to the database
    boolean addMember(CustomerEntity entity);

    // Method to retrieve a particular customer by ID from the database
    CustomerEntity getParticularCustomer(int id);

    // Method to update details of an existing member in the database
    boolean updateMember(CustomerEntity entity);

    // Method to delete a member by ID from the database
    boolean delete(int id);
}
