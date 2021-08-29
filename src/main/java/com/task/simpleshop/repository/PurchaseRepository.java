package com.task.simpleshop.repository;

import com.task.simpleshop.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Purchase findPurchaseByExternalId(String externalId);

    void  deleteByPurchaseId(String purchaseId);

    Purchase getPurchaseByPurchaseId(String purchaseId);
}
