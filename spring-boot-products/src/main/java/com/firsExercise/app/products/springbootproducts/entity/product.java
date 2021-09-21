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
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

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
        this.createAt = dateCreate;
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
        return createAt;
    }

}
