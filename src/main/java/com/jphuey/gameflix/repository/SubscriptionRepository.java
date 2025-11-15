package com.jphuey.gameflix.repository;

import com.jphuey.gameflix.model.Subscription;
import com.jphuey.gameflix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUser(User user);
}