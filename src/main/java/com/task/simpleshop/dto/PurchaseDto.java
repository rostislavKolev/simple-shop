package com.task.simpleshop.dto;

import java.sql.Timestamp;
import java.util.List;

public class PurchaseDto extends BaseDto {
    private String purchaseId;

    private SubscriberDto subscriber;

    private String externalId;

    private List<PurchaseDetailsDto> purchaseDetails;

    private Timestamp creationDate;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public SubscriberDto getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(SubscriberDto subscriber) {
        this.subscriber = subscriber;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public List<PurchaseDetailsDto> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetailsDto> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
