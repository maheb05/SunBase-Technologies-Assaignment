package com.sunbaseAssaignment.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbaseAssaignment.entity.CustomerEntity;
import com.sunbaseAssaignment.exception.InvalidCredintialsExceptions;
import com.sunbaseAssaignment.service.LoginService;

@Controller
public class LoginController {

    private LoginService loginService;

    // Default constructor for the controller
    public LoginController() {
        System.out.println("Default Login Controller");
    }

    // Constructor with autowired LoginService
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Mapping to handle login form submission
    @RequestMapping(value = "/loginForm", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println("Login Controller");

        try {
            // Call service to authenticate admin entity
            boolean entity = loginService.getAdminEntityByEmail(email, password);
            System.out.println(entity);

            if (entity) {
                System.out.println("Going to home page");
                return "forward:/viewAll";
            } else {
                System.out.println("Invalid credentials");
                model.addAttribute("invalid", "Invalid Credentials");
            }
        } catch (EntityNotFoundException | InvalidCredintialsExceptions e) {
            System.out.println("Exception found in controller");
            model.addAttribute("invalid", e.getMessage());
            e.printStackTrace();
        }
        return "/WEB-INF/login.jsp";
    }

    // Mapping to retrieve all customer list
    @RequestMapping(value = "/viewAll")
    public String getAllCustomerList(Model model) {

        // Call service to get all customer list
        List<CustomerEntity> customerList = loginService.getAllCustomerList();
        model.addAttribute("customer", customerList);
        return "forward:/WEB-INF/viewAll.jsp";
    }

    // Mapping to navigate to addMember page
    @RequestMapping(value = "/addMember")
    public String addMember() {
        return "WEB-INF/addMember.jsp";
    }
}
