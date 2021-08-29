package com.task.simpleshop.dto;

import java.sql.Timestamp;

public class PurchaseDetailsDto extends BaseDto {
    private String purchaseDetailsId;

    private PurchaseDto purchase;

    private ProductDto product;

    private long quantity;

    private Timestamp creationDate;

    public String getPurchaseDetailsId() {
        return purchaseDetailsId;
    }

    public void setPurchaseDetailsId(String purchaseDetailsId) {
        this.purchaseDetailsId = purchaseDetailsId;
    }

    public PurchaseDto getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDto purchase) {
        this.purchase = purchase;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
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
