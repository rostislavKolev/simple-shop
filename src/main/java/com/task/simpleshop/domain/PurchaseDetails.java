package com.task.simpleshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "purchase_details")
public class PurchaseDetails extends BasicEntity {

    private static final long serialVersionUID = 2026552617476663023L;

    @Column(name = "purchase_details_id", nullable = false)
    private String purchaseDetailsId;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private long quantity;

    public String getPurchaseDetailsId() {
        return purchaseDetailsId;
    }

    public void setPurchaseDetailsId(String purchaseDetailsId) {
        this.purchaseDetailsId = purchaseDetailsId;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
