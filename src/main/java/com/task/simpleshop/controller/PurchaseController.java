package com.task.simpleshop.controller;

import com.task.simpleshop.dto.PurchaseDetailsDto;
import com.task.simpleshop.dto.PurchaseDto;
import com.task.simpleshop.model.request.PurchaseDetailRequestModel;
import com.task.simpleshop.model.request.PurchaseRequestModel;
import com.task.simpleshop.model.response.ProductResponseModel;
import com.task.simpleshop.model.response.PurchaseResponseModel;
import com.task.simpleshop.service.ProductService;
import com.task.simpleshop.service.PurchaseService;
import com.task.simpleshop.service.SubscriberService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private PurchaseService purchaseService;
    private SubscriberService subscriberService;
    private ProductService productService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, SubscriberService subscriberService, ProductService productService) {
        this.purchaseService = purchaseService;
        this.subscriberService = subscriberService;
        this.productService = productService;
    }

    @GetMapping(path = "/{purchaseId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PurchaseResponseModel> getPurchase(@PathVariable String purchaseId) {
        PurchaseDto purchaseDto = purchaseService.getPurchase(purchaseId);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        PurchaseResponseModel response  = modelMapper.map(purchaseDto, PurchaseResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductResponseModel> createPurchase(@RequestBody PurchaseRequestModel purchaseRequest) {
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setExternalId(purchaseRequest.getExternalId());
        purchaseDto.setSubscriber(subscriberService.getSubscriber(purchaseRequest.getSubscriberId()));
        purchaseDto.setPurchaseDetails(new ArrayList<>());

        for (PurchaseDetailRequestModel purchaseDetail : purchaseRequest.getPurchaseDetails()) {
            PurchaseDetailsDto purchaseDetailsDto = new PurchaseDetailsDto();
            purchaseDetailsDto.setPurchase(purchaseDto);
            purchaseDetailsDto.setProduct(productService.getProduct(purchaseDetail.getProductId()));
            purchaseDetailsDto.setQuantity(purchaseDetail.getQuantity());
            purchaseDto.getPurchaseDetails().add(purchaseDetailsDto);
        }
        purchaseService.createPurchase(purchaseDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
