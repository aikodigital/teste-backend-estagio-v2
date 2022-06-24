package com.example.demo.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tb_movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;
}
