package com.firsExercise.app.products.springbootproducts.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    @Temporal(TemporalType.DATE)
    private Date dateCreate;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

}
