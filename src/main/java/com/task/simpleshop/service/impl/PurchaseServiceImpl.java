package com.task.simpleshop.service.impl;

import com.task.simpleshop.domain.Purchase;
import com.task.simpleshop.domain.PurchaseDetails;
import com.task.simpleshop.dto.PurchaseDto;
import com.task.simpleshop.repository.PurchaseRepository;
import com.task.simpleshop.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PurchaseDto getPurchase(String purchaseId) {
        Purchase purchase = purchaseRepository.getPurchaseByPurchaseId(purchaseId);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        PurchaseDto purchaseDto = modelMapper.map(purchase, PurchaseDto.class);
        return purchaseDto;
    }

    @Override
    public void createPurchase(PurchaseDto purchaseDto) {
        Purchase purchase = purchaseRepository.findPurchaseByExternalId(purchaseDto.getExternalId());
        if (purchase != null) {
            throw new RuntimeException("Purchase already exists");
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        purchase = modelMapper.map(purchaseDto, Purchase.class);
        purchase.setCreationDate(Timestamp.from(Instant.now()));
        purchase.setPurchaseId(UUID.randomUUID().toString());
        for (PurchaseDetails purchaseDetails : purchase.getPurchaseDetails()) {
            purchaseDetails.setPurchaseDetailsId(UUID.randomUUID().toString());
            purchaseDetails.setCreationDate(Timestamp.from(Instant.now()));
        }
        purchaseRepository.save(purchase);
    }
}
