package com.sunbaseAssaignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbaseAssaignment.entity.CustomerEntity;
import com.sunbaseAssaignment.service.CustomerService;

@Controller
public class CustomerController {

    private CustomerService customerService;

    // Default constructor for the controller
    public CustomerController() {
        System.out.println("Default Customer Controller");
    }

    // Constructor with autowired CustomerService
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Mapping to handle member addition form submission
    @RequestMapping(value = "/memberAdd", method = RequestMethod.POST)
    public String addMember(@RequestParam String firstName,
            @RequestParam String lastName, @RequestParam String street, @RequestParam String address,
            @RequestParam String city, @RequestParam String state, @RequestParam String email, @RequestParam long phone,
            Model model) {
        
        System.out.println("Add Member controller");
        
        // Call service to add a new member
        boolean addMember = customerService.addMember(firstName, lastName, street, address, city, state, email, phone);

        if (addMember) {
            model.addAttribute("SuccessFul", "Successfully Added");
            System.out.println("Data stored");
            return "forward:/viewAll";
        } else {
            System.out.println("Data not stored");
            model.addAttribute("wrong", "Something went wrong while adding");
        }

        return "/WEB-INF/addMember.jsp";
    }

    // Mapping to handle editing of a customer
    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        System.out.println("Editing controller");

        // Retrieve customer entity by id
        CustomerEntity entity = customerService.getCustomer(id);

        // Set model attributes for editing
        model.addAttribute("firstName", entity.getFirstName());
        model.addAttribute("lastName", entity.getLastName());
        model.addAttribute("street", entity.getStreet());
        model.addAttribute("address", entity.getAddress());
        model.addAttribute("city", entity.getCity());
        model.addAttribute("state", entity.getState());
        model.addAttribute("email", entity.getEmail());
        model.addAttribute("phone", entity.getPhone());

        return "/WEB-INF/edit.jsp";
    }

    // Mapping to handle updating customer details
    @RequestMapping(value = "/updateDetails", method = RequestMethod.POST)
    public String update(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String street, @RequestParam String address, @RequestParam String city,
            @RequestParam String state, @RequestParam String email, @RequestParam long phone, Model model) {

        System.out.println("Update Controller");

        // Call service to update customer details
        boolean member = customerService.updateMember(id, firstName, lastName, street, address, city, state, email, phone);

        if (member) {
            model.addAttribute("success", "Update successful");
            return "forward:/viewAll";
        } else {
            model.addAttribute("error", "Something went wrong while updating... please try again");
            return "/WEB-INF/viewAll.jsp";
        }
    }

    // Mapping to handle deleting a customer
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        System.out.println("Delete Controller");

        // Call service to delete a customer
        boolean delete = customerService.delete(id);

        if (delete) {
            model.addAttribute("deleted", "Member deleted successfully");
            return "forward:/viewAll";
        } else {
            model.addAttribute("notdeleted", "Member deletion unsuccessful");
            return "forward:/viewAll";
        }
    }
}
