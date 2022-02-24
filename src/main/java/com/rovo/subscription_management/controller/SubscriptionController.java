package com.rovo.subscription_management.controller;


import com.rovo.subscription_management.model.Subscription;
import com.rovo.subscription_management.service.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscription")
@Slf4j
public class SubscriptionController {


    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createSubscription(Subscription subscription){
        try {
            subscriptionService.addUSubscription(subscription);
            log.info("New subscription is created");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error("Invalid User");
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
