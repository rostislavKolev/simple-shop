package com.task.simpleshop.model.response;

public class PurchaseDetailResponseModel {
    private String purchaseDetailsId;
    private ProductResponseModel product;
    private long quantity;

    public String getPurchaseDetailsId() {
        return purchaseDetailsId;
    }

    public void setPurchaseDetailsId(String purchaseDetailsId) {
        this.purchaseDetailsId = purchaseDetailsId;
    }

    public ProductResponseModel getProduct() {
        return product;
    }

    public void setProduct(ProductResponseModel product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
