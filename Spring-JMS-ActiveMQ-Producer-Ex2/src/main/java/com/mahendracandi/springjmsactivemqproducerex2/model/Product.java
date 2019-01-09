package com.mahendracandi.springjmsactivemqproducerex2.model;

import java.io.Serializable;

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
    public String toString() {
        return "Product{" + "productId='" + productId + '\'' + ", name='" + name + '\'' + ", qty=" + qty + '}';
    }
}
