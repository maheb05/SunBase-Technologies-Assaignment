package com.sunbaseAssaignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


 //* The {@code CustomerEntity} class represents the entity for customers in the system.
 //* It is annotated with JPA annotations to define its mapping to the corresponding database table.

@Entity
@Table(name = "customer_table")
public class CustomerEntity {

    // Id annotation to specify the primary key of the entity
    @Id
    @Column(name = "ID")
    private int id;

    // Column annotation to map the 'FIRST_NAME' column in the database
    @Column(name = "FIRST_NAME")
    private String firstName;

    // Column annotation to map the 'LAST_NAME' column in the database
    @Column(name = "LAST_NAME")
    private String lastName;

    // Column annotation to map the 'STREET' column in the database
    @Column(name = "STREET")
    private String street;

    // Column annotation to map the 'ADDRESS' column in the database
    @Column(name = "ADDRESS")
    private String address;

    // Column annotation to map the 'CITY' column in the database
    @Column(name = "CITY")
    private String city;

    // Column annotation to map the 'STATE' column in the database
    @Column(name = "STATE")
    private String state;

    // Column annotation to map the 'EMAIL' column in the database
    @Column(name = "EMAIL")
    private String email;

    // Column annotation to map the 'PHONE' column in the database
    @Column(name = "PHONE")
    private long phone;

    // Default constructor for the entity
    public CustomerEntity() {

    }

    // Parameterized constructor with all attributes for the entity
    public CustomerEntity(int id, String firstName, String lastName, String street, String address, String city,
                          String state, String email, long phone) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
    }

    // Parameterized constructor without 'id' for the entity
    public CustomerEntity(String firstName, String lastName, String street, String address, String city,
                          String state, String email, long phone) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
    }

    // Getter and Setter methods for all attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    // toString method to provide a string representation of the entity
    @Override
    public String toString() {
        return getId() + " " + getFirstName() + " " + getLastName() + " " + getStreet() +
                " " + getAddress() + " " + getCity() + " " + getState() + " " + getEmail() + " " + getPhone();
    }
}
