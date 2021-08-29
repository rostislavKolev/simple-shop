package com.task.simpleshop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purchases")
public class Purchase extends BasicEntity {

    private static final long serialVersionUID = -1413501224000111611L;

    @Column(name = "purchase_id", nullable = false, unique = true)
    private String purchaseId;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    @Column(name = "external_id")
    private String externalId;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetails> purchaseDetails;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public List<PurchaseDetails> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetails> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }
}
