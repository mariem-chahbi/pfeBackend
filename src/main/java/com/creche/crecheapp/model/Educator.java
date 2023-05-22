package com.creche.crecheapp.model;

import javax.persistence.*;

@Entity
@Table(name = "educator")
public class Educator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
*/
    @Column(nullable = false)
    private String phoneNumber;


}
