package com.sunbaseAssaignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunbaseAssaignment.dao.AdminDAO;
import com.sunbaseAssaignment.entity.AdminEntity;

/**
 * The {@code AdminService} class provides business logic related to Admin entities.
 */
@Component
public class AdminService {

    private AdminDAO adminDAO;

    /**
     * Constructs a new instance of {@code AdminService} with the specified AdminDAO.
     *
     * @param adminDAO The data access object for Admin entities.
     */
    @Autowired
    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    /**
     * Default constructor for AdminService.
     */
    public AdminService() {
        System.out.println("Default Admin service Constructor");
    }

    /**
     * Validates and saves Admin entity if the provided information is valid.
     *
     * @param fullName The full name of the Admin.
     * @param email    The email of the Admin.
     * @param password The password of the Admin.
     * @param phone    The phone number of the Admin.
     * @param gender   The gender of the Admin.
     * @param dob      The date of birth of the Admin.
     * @return True if the Admin entity is successfully saved, false otherwise.
     */
    public boolean saveAdminEntity(String fullName, String email, String password, long phone, String gender, String dob) {
        boolean isValid = false;

        // Validate input parameters
        if (fullName != null && !fullName.isEmpty() && !fullName.isBlank()) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (email != null && !email.isEmpty() && !email.isBlank()) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (password != null && !password.isEmpty() && !password.isBlank()) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (phone > 0) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (gender != null && !gender.isEmpty() && !gender.isBlank()) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (dob != null && !dob.isEmpty() && !dob.isBlank()) {
            isValid = true;
        } else {
            isValid = false;
        }

        // If input parameters are valid, create AdminEntity and save it
        if (isValid) {
            AdminEntity entity = new AdminEntity(fullName, email, password, phone, gender, dob);
            boolean saveAdminEntity = adminDAO.saveAdminEntity(entity);
            return saveAdminEntity;
        }
        return isValid;
    }
}
