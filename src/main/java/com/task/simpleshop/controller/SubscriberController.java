package com.task.simpleshop.controller;

import com.task.simpleshop.dto.SubscriberDto;
import com.task.simpleshop.model.request.SubscriberRequestModel;
import com.task.simpleshop.model.response.SubscriberResponseModel;
import com.task.simpleshop.service.SubscriberService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribers")
public class SubscriberController {

    private SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping(path = "/{subscriberId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SubscriberResponseModel> getSubscriber(@PathVariable String subscriberId) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        SubscriberDto subscriberDto = subscriberService.getSubscriber(subscriberId);
        SubscriberResponseModel responseModel = modelMapper.map(subscriberDto, SubscriberResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,}, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SubscriberResponseModel> createSubscriber(@RequestBody SubscriberRequestModel subscriberRequest) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        SubscriberDto subscriberDto = modelMapper.map(subscriberRequest, SubscriberDto.class);
        subscriberDto = subscriberService.createSubscriber(subscriberDto);
        SubscriberResponseModel responseModel = modelMapper.map(subscriberDto, SubscriberResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

    @PutMapping(path = "/{subscriberId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SubscriberResponseModel> updateSubscriber(@PathVariable String subscriberId,
                                                                    @RequestBody SubscriberRequestModel newSubscriberRequest) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        SubscriberDto newSubscriberDto = modelMapper.map(newSubscriberRequest, SubscriberDto.class);
        newSubscriberDto = subscriberService.updateSubscriber(subscriberId, newSubscriberDto);
        SubscriberResponseModel responseModel = modelMapper.map(newSubscriberDto, SubscriberResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @DeleteMapping(path = "/{subscriberId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity deleteSubscriber(@PathVariable String subscriberId) {
        subscriberService.deleteSubscriberBySubscriberId(subscriberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
