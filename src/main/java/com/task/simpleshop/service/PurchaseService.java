package com.task.simpleshop.service;

import com.task.simpleshop.dto.PurchaseDto;

public interface PurchaseService {
    void createPurchase(PurchaseDto purchaseDto);

    PurchaseDto getPurchase(String purchaseId);
}
