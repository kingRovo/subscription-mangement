package com.rovo.subscription_management.service;


import com.rovo.subscription_management.model.Subscription;
import com.rovo.subscription_management.repository.SubscriptionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepo subscriptionRepo;

    public void addUSubscription(Subscription subscription){
        subscriptionRepo.save(subscription);
    }

}
