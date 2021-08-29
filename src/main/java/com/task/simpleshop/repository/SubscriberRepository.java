package com.task.simpleshop.repository;

import com.task.simpleshop.domain.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    Subscriber findByEmail(String email);

    Subscriber findBySubscriberId(String subscriberId);
}
