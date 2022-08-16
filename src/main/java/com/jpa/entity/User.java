package com.jpa.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false , unique = true)
    private Integer id;

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "name")
    private String name;



}
