package com.task.simpleshop.model.response;

import java.sql.Timestamp;
import java.util.List;

public class PurchaseResponseModel {
    private String purchaseId;

    private String externalId;

    private SubscriberResponseModel subscriber;

    private List<PurchaseDetailResponseModel> purchaseDetails;

    private Timestamp creationDate;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public SubscriberResponseModel getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(SubscriberResponseModel subscriber) {
        this.subscriber = subscriber;
    }

    public List<PurchaseDetailResponseModel> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetailResponseModel> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
