package com.sunbaseAssaignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


 //* The {@code AdminEntity} class represents the entity for administrators in the system.
 //* It is annotated with JPA annotations to define its mapping to the corresponding database table.
 
@Entity
@Table(name = "admin_table")
public class AdminEntity {

    // Id annotation to specify the primary key of the entity
    @Id
    @Column(name = "ID")
    private int id;

    // Column annotation to map the 'FULL_NAME' column in the database
    @Column(name = "FULL_NAME")
    private String fullName;

    // Column annotation to map the 'EMAIL' column in the database
    @Column(name = "EMAIL")
    private String email;

    // Column annotation to map the 'PASSWORD' column in the database
    @Column(name = "PASSWORD")
    private String password;

    // Column annotation to map the 'PHONE' column in the database
    @Column(name = "PHONE")
    private long phone;

    // Column annotation to map the 'GENDER' column in the database
    @Column(name = "GENDER")
    private String gender;

    // Column annotation to map the 'DOB' column in the database
    @Column(name = "DOB")
    private String dob;

    // Default constructor for the entity
    public AdminEntity() {

    }

    // Parameterized constructor with all attributes for the entity
    public AdminEntity(int id, String fullName, String email, String password, long phone, String gender, String dob) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
    }

    // Parameterized constructor without 'id' for the entity
    public AdminEntity(String fullName, String email, String password, long phone, String gender, String dob) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
    }

    // Getter and Setter methods for all attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    // toString method to provide a string representation of the entity
    @Override
    public String toString() {
        return getId() + " " + getFullName() + " " + getEmail() + " " + getPassword() +
                " " + getPhone() + " " + getGender() + " " + getDob();
    }
}
