package com.task.simpleshop.model.request;

import java.sql.Timestamp;
//TODO: Add validations
public class PurchaseDetailRequestModel {
    private String productId;
    private long quantity;
    private Timestamp creationDate;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
