package com.rovo.subscription_management.service;

import com.rovo.subscription_management.model.Subscription;
import com.rovo.subscription_management.repository.PlanRepo;
import com.rovo.subscription_management.repository.SubscriptionRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepo subscriptionRepo;

    private final PlanRepo planRepo;

    /**
     * add new subscription and add starting and expire date in database
     * @param subscription
     */
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


    /**
     * linking plan to subscriber
     * @param subscription_id
     * @param plan_id
     * @throws NullPointerException
     */

    public void setPlan(Long subscription_id, Long plan_id) throws NullPointerException{

        if(!planRepo.getById(plan_id).equals(null)) {

            Subscription subscription = subscriptionRepo.findById(subscription_id).orElseThrow();
            subscription.setPlan_id(plan_id);
            subscriptionRepo.save(subscription);

        }


    }

    /**
     * this method return list of subscription
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @return
     */

    public List<Subscription> getAllServices(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Subscription> pagedResult = subscriptionRepo.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Subscription>();
        }
    }


}
