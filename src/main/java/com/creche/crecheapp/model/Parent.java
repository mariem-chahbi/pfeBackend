package com.creche.crecheapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data

@Entity

@Table(name = "parent")
public class Parent   implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    String firstname;
    String lastname;

    //@Size(max = 8, message = "CIN must have a maximum length of 8")
    String cin;


    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
*/
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String phoneNumber;

/*
    @JsonIgnoreProperties("parent")
    //@JsonManagedReference
    @OneToMany(mappedBy = "parent",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Child> children;
*/


   /* @JsonIgnoreProperties("parent")
    //@JsonManagedReference
    @OneToMany(mappedBy = "parent",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Child> children;*/

    public Parent(String firstname, String lastname, String cin, Integer id, String address, String location, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cin = cin;
        this.id = id;
        this.address = address;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public Parent() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
/*
    public List<Child> getChildren() {
   /* public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;

    }
    */

}

