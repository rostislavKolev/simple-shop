package com.task.simpleshop.service;

import com.task.simpleshop.dto.SubscriberDto;

public interface SubscriberService {
    SubscriberDto createSubscriber(SubscriberDto subscriberDto);

    SubscriberDto updateSubscriber(String subscriberId, SubscriberDto newSubscriberDto);

    SubscriberDto getSubscriber(String subscriberId);

    void deleteSubscriberBySubscriberId(String productId);
}
