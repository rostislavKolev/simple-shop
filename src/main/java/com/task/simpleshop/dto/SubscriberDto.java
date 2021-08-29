package com.task.simpleshop.dto;

import com.task.simpleshop.domain.Purchase;
import java.util.List;

public class SubscriberDto extends BaseDto {

    private static final long serialVersionUID = 6591598665063885048L;

    private String subscriberId;

    private String firstName;

    private String lastName;

    private String email;

    private List<Purchase> purchases;

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
