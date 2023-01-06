package com.integrador.backend.model;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public String name;

    //Constructor
    public Role() {
    }

    //Getters and Setter
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
}
