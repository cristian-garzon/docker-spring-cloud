package com.firsExercise.app.products.springbootproducts.entity;

public class item {
    private product product;
    private double quiantity;

    public item(com.firsExercise.app.products.springbootproducts.entity.product product, double quiantity) {
        this.product = product;
        this.quiantity = quiantity;
    }

    public void setProduct(com.firsExercise.app.products.springbootproducts.entity.product product) {
        this.product = product;
    }

    public void setQuiantity(double quiantity) {
        this.quiantity = quiantity;
    }

    public com.firsExercise.app.products.springbootproducts.entity.product getProduct() {
        return product;
    }

    public double getQuiantity() {
        return quiantity;
    }

    public double getTotal(){
        return getProduct().getPrice() * this.quiantity;
    }
}
