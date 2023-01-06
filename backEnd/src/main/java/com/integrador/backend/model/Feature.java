package com.integrador.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "features")
public class Feature {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String detail;

    //Relations

    @ManyToMany(mappedBy = "features")
    @JsonIgnore
    private List<Product> products;

    //Constructor
    public Feature() {
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return detail;
    }

    public void setIcon(String detail) {
        this.detail = detail;
    }
}