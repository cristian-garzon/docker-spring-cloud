package com.springdocker.app.item.entity;

public class Item {
    private Product product;
    private Integer size;

    public Item(){
    }

    public Item(Product product, Integer size) {
        this.product = product;
        this.size = size;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getSize() {
        return size;
    }

    public Double getTotal() {
        return product.getPrice() * size.doubleValue();
    }
}
