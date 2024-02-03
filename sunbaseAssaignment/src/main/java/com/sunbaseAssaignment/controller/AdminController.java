package com.sunbaseAssaignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbaseAssaignment.service.AdminService;

@Controller
public class AdminController {

    private AdminService adminService;

    // Default constructor for the controller
    public AdminController() {
        System.out.println("Default Admin Controller");
    }

    // Constructor with autowired AdminService
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Mapping to display registration page
    @RequestMapping(value = "/register")
    public String goToRegister() {
        return "/WEB-INF/register.jsp";
    }

    // Mapping to display login page
    @RequestMapping(value = "/login")
    public String goToLogin() {
        return "/WEB-INF/login.jsp";
    }

    // Mapping to process registration form submission
    @RequestMapping(value = "/processRegistration")
    public String registration(@RequestParam String fullName,
            @RequestParam String email, @RequestParam String password, @RequestParam long phone,
            @RequestParam String gender, @RequestParam String dob, Model model) {
        
        // Call service to save admin entity
        boolean saveAdminEntity = adminService.saveAdminEntity(fullName, email, password, phone, gender, dob);

        // Check the result and set appropriate messages
        if (saveAdminEntity) {
            model.addAttribute("successMessage", "Successfully Registered");
            return "/WEB-INF/registerSuccess.jsp";
        } else {
            model.addAttribute("errorMessage", "Something Went Wrong please check all your details");
            return "/WEB-INF/register.jsp";
        }
    }

    // Mapping to display registration success page
    @RequestMapping(value = "/registerSuccess")
    public String registrationSuccess() {
        return "/WEB-INF/login.jsp";
    }
}
