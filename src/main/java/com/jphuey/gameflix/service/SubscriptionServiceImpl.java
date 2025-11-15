package com.jphuey.gameflix.service;

import com.jphuey.gameflix.model.Subscription;
import com.jphuey.gameflix.model.User;
import com.jphuey.gameflix.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription subscribeUser(Subscription subscription) {
        subscription.setActive(true);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getSubscriptionsByUser(User user) {
        return subscriptionRepository.findByUser(user);
    }

    @Override
    public Optional<Subscription> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public void cancelSubscription(Long id) {
        subscriptionRepository.findById(id).ifPresent(sub -> {
            sub.setActive(false);
            subscriptionRepository.save(sub);
        });
    }
}