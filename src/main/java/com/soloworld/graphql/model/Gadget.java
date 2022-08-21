package com.soloworld.graphql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gadget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double cost;
    private String country;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gadget(double cost, String country, String name) {
        this.cost = cost;
        this.country = country;
        this.name = name;
    }

    public Gadget() {
    }
}
