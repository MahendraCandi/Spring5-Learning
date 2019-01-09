package com.mahendracandi.springjmsactivemqproducerex1.model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private String productId;

    private String name;

    private int qty;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getQty() == product.getQty() && Objects.equals(getProductId(), product.getProductId()) && Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getName(), getQty());
    }

    @Override
    public String toString() {
        return "Product{" + "productId='" + productId + '\'' + ", name='" + name + '\'' + ", qty=" + qty + '}';
    }
}

