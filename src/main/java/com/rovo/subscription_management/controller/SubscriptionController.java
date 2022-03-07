package com.rovo.subscription_management.controller;


import com.rovo.subscription_management.model.Subscription;
import com.rovo.subscription_management.service.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/subscriptions")
@Slf4j
public class SubscriptionController {


    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/")
    private ResponseEntity<?> createSubscription( @Valid @RequestBody Subscription subscription){
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

    @GetMapping("/")
    public ResponseEntity<List<Subscription>> FindAllSubscription(){

        try{

            return new ResponseEntity<>(subscriptionService.displayAllSubscription(),HttpStatus.OK);
        }
        catch (Exception exception){

            log.error("Invalid request for fetching data... ");
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/{subscription_id}/plans/{plan_id}")
    ResponseEntity setPlan(@PathVariable("subscription_id")Long subscription_id,@PathVariable("plan_id")Long plan_id){

        try{
            subscriptionService.setPlan(subscription_id,plan_id);

            log.info("Set Plan {} To Subscription {}"+plan_id,subscription_id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception exception){
            log.error("Invalid request for set plan");

            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
