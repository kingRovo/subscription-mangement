package com.rovo.subscription_management.service;

import com.rovo.subscription_management.model.Subscription;
import com.rovo.subscription_management.repository.PlanRepo;
import com.rovo.subscription_management.repository.SubscriptionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepo subscriptionRepo;

    private final PlanRepo planRepo;

    public void addUSubscription(Subscription subscription){

        Calendar cal = Calendar.getInstance();
        if(subscription.getType().equalsIgnoreCase("monthly")){

            subscription.setStartDate(cal.getTime());
            cal.add(Calendar.MONTH, 1);
            subscription.setExpireDate(cal.getTime());
            subscriptionRepo.save(subscription);
        }
        else if(subscription.getType().equalsIgnoreCase("yearly")){


            subscription.setStartDate(cal.getTime());//add start date to subscription.
            cal.add(Calendar.YEAR, 1);
            subscription.setExpireDate(cal.getTime());//set expire date by 1 year
            subscriptionRepo.save(subscription);

        }
    }

    public List<Subscription> displayAllSubscription(){
        return subscriptionRepo.findAll();
    }


    public void setPlan(Long subscription_id, Long plan_id) throws NullPointerException{

        if(!planRepo.getById(plan_id).equals(null)) {

            Subscription subscription = subscriptionRepo.findById(subscription_id).orElseThrow();
            subscription.setPlan_id(plan_id);
            subscriptionRepo.save(subscription);

        }


    }


}
