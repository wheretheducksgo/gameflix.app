package com.jphuey.gameflix.service;

import com.jphuey.gameflix.model.Subscription;
import com.jphuey.gameflix.model.User;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    Subscription subscribeUser(Subscription subscription);
    List<Subscription> getSubscriptionsByUser(User user);
    Optional<Subscription> getSubscriptionById(Long id);
    void cancelSubscription(Long id);
}