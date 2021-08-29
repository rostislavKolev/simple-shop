package com.task.simpleshop.model.request;

import java.sql.Timestamp;
import java.util.List;

//TODO: Add validations
public class PurchaseRequestModel {

    private String externalId;

    private String subscriberId;

    private List<PurchaseDetailRequestModel> purchaseDetails;

    private Timestamp creationDate;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public List<PurchaseDetailRequestModel> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetailRequestModel> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
