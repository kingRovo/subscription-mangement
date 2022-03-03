package com.rovo.subscription_management.service;


import com.rovo.subscription_management.model.Plan;
import com.rovo.subscription_management.model.Subscription;
import com.rovo.subscription_management.repository.PlanRepo;
import com.rovo.subscription_management.repository.SubscriptionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepo subscriptionRepo;

    private final PlanRepo planRepo;

    public void addUSubscription(Subscription subscription){
        subscriptionRepo.save(subscription);
    }

    public List<Subscription> displayAllSubscription(){
        return subscriptionRepo.findAll();
    }


    public void setPlan(Long subscription_id, Long planid) throws NullPointerException{

        if(!planRepo.getById(planid).equals(null)) {

            Subscription subscription = subscriptionRepo.findById(subscription_id).orElseThrow();
            subscription.setPlan_id(planid);

        }

    }


}
