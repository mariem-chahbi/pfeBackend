package com.creche.crecheapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue
    int id;
 /*   @JsonManagedReference
    @OneToMany(mappedBy = "admin",fetch = FetchType.EAGER,cascade = CascadeType.ALL)

    private List<User> user;
*/

    @JsonIgnoreProperties("Admin")
    //@JsonManagedReference
    @OneToMany(mappedBy = "admin",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> events;
    @JsonIgnoreProperties("Admin")
    //@JsonManagedReference
    @OneToMany(mappedBy = "admin",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Post> posts;

}
