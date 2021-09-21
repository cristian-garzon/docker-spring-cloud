package com.springdocker.app.item.entity;


import java.util.Date;

public class Product {
    private Long id;
    private double price;
    private String name;
    private Date createAt;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getCreateAt() {
        return createAt;
    }
}
