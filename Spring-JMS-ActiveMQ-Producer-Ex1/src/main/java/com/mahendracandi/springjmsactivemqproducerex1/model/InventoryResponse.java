package com.mahendracandi.springjmsactivemqproducerex1.model;

import java.io.Serializable;
import java.util.Objects;

public class InventoryResponse implements Serializable {
    private String productId;

    private int returnCode;

    private String comment;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryResponse response = (InventoryResponse) o;
        return getReturnCode() == response.getReturnCode() && Objects.equals(getProductId(), response.getProductId()) && Objects.equals(getComment(), response.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getReturnCode(), getComment());
    }

    @Override
    public String toString() {
        return "InventoryResponse{" + "productId='" + productId + '\'' + ", returnCode=" + returnCode + ", comment='" + comment + '\'' + '}';
    }
}
