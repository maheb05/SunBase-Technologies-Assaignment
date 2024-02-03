package com.sunbaseAssaignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunbaseAssaignment.dao.CustomerDAO;
import com.sunbaseAssaignment.entity.CustomerEntity;

/**
 * The {@code CustomerService} class provides business logic related to Customer entities.
 */
@Component
public class CustomerService {

    private CustomerDAO customerDAO;

    /**
     * Default constructor for CustomerService.
     */
    public CustomerService() {
        System.out.println("Default Customer service");
    }

    /**
     * Constructs a new instance of {@code CustomerService} with the specified CustomerDAO.
     *
     * @param customerDAO The data access object for Customer entities.
     */
    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * Adds a new Customer member.
     *
     * @param firstName The first name of the Customer.
     * @param lastName  The last name of the Customer.
     * @param street    The street of the Customer.
     * @param address   The address of the Customer.
     * @param city      The city of the Customer.
     * @param state     The state of the Customer.
     * @param email     The email of the Customer.
     * @param phone     The phone number of the Customer.
     * @return True if the Customer entity is successfully added, false otherwise.
     */
    public boolean addMember(String firstName, String lastName, String street, String address, String city, String state, String email, long phone) {
        CustomerEntity entity = new CustomerEntity(firstName, lastName, street, address, city, state, email, phone);
        return customerDAO.addMember(entity);
    }

    /**
     * Retrieves a specific Customer by ID.
     *
     * @param id The ID of the Customer.
     * @return The CustomerEntity corresponding to the given ID.
     */
    public CustomerEntity getCustomer(int id) {
        return customerDAO.getParticularCustomer(id);
    }

    /**
     * Updates details of an existing Customer member.
     *
     * @param id        The ID of the Customer.
     * @param firstName The first name of the Customer.
     * @param lastName  The last name of the Customer.
     * @param street    The street of the Customer.
     * @param address   The address of the Customer.
     * @param city      The city of the Customer.
     * @param state     The state of the Customer.
     * @param email     The email of the Customer.
     * @param phone     The phone number of the Customer.
     * @return True if the Customer entity is successfully updated, false otherwise.
     */
    public boolean updateMember(int id, String firstName, String lastName, String street, String address, String city, String state, String email, long phone) {
        CustomerEntity entity = new CustomerEntity(id, firstName, lastName, street, address, city, state, email, phone);
        return customerDAO.updateMember(entity);
    }

    /**
     * Deletes a Customer member by ID.
     *
     * @param id The ID of the Customer to be deleted.
     * @return True if the Customer entity is successfully deleted, false otherwise.
     */
    public boolean delete(int id) {
        return customerDAO.delete(id);
    }
}
