package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "ad_details")
public class AdDetails {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String location;

    public AdDetails(double price, String location) {
        this.price = price;
        this.location = location;
    }


    public AdDetails(double price, String location, long id ) {
        this.price = price;
        this.location = location;
        this.id = id;
    }

    public AdDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}