package com.task.simpleshop.service.impl;

import com.task.simpleshop.domain.Subscriber;
import com.task.simpleshop.dto.SubscriberDto;
import com.task.simpleshop.exceptions.SubscriberServiceException;
import com.task.simpleshop.repository.SubscriberRepository;
import com.task.simpleshop.service.SubscriberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    private SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public SubscriberDto getSubscriber(String subscriberId) {
        Subscriber subscriber = this.getSubscriberBySubscriberIdIfExists(subscriberId);
        if (subscriber == null) {
            throw new SubscriberServiceException("Subscriber with ID " + subscriberId + " not found.");
        }
        ModelMapper modelMapper = new ModelMapper();
        SubscriberDto subscriberEntity = modelMapper.map(subscriber, SubscriberDto.class);
        return subscriberEntity;
    }


    @Override
    public SubscriberDto createSubscriber(SubscriberDto newSubscriber) {
        if (subscriberRepository.findByEmail(newSubscriber.getEmail()) != null) {
            throw new SubscriberServiceException("Subscriber already exists");
        }
        ModelMapper modelMapper = new ModelMapper();
        Subscriber subscriberEntity = modelMapper.map(newSubscriber, Subscriber.class);
        subscriberEntity.setSubscriberId(UUID.randomUUID().toString());
        subscriberEntity.setCreationDate(Timestamp.from(Instant.now()));
        subscriberEntity = this.subscriberRepository.save(subscriberEntity);
        SubscriberDto returnValue = modelMapper.map(subscriberEntity, SubscriberDto.class);
        return returnValue;
    }

    @Override
    public SubscriberDto updateSubscriber(String subscriberId, SubscriberDto newSubscriberDto) {
        Subscriber subscriber = this.getSubscriberBySubscriberIdIfExists(subscriberId);

        if (checkIfEmailIsTaken(newSubscriberDto.getEmail(), subscriberId)) {
            throw new SubscriberServiceException("Subscriber with email " + newSubscriberDto.getEmail() + " already exists.");
        }

        subscriber.setFirstName(newSubscriberDto.getFirstName());
        subscriber.setLastName(newSubscriberDto.getLastName());
        subscriber.setEmail(newSubscriberDto.getEmail());
        subscriber = subscriberRepository.save(subscriber);
        ModelMapper modelMapper = new ModelMapper();
        SubscriberDto returnValue = modelMapper.map(subscriber, SubscriberDto.class);

        return returnValue;
    }

    @Override
    public void deleteSubscriberBySubscriberId(String subscriberId) {
        Subscriber subscriber = this.getSubscriberBySubscriberIdIfExists(subscriberId);
        subscriberRepository.delete(subscriber);
    }

    private Subscriber getSubscriberBySubscriberIdIfExists(String subscriberId) throws SubscriberServiceException {
        Subscriber subscriber = subscriberRepository.findBySubscriberId(subscriberId);
        if (subscriber == null) {
            throw new SubscriberServiceException("Subscriber with ID " + subscriberId + " not found.");
        }
        return subscriber;
    }

    private boolean checkIfEmailIsTaken(String email, String subscriberId) {
        Subscriber subscriberWithSameMail = subscriberRepository.findByEmail(email);
        if (subscriberWithSameMail != null && !subscriberWithSameMail.getSubscriberId().equals(subscriberId)) {
            return true;
        }
        return false;
    }
}
