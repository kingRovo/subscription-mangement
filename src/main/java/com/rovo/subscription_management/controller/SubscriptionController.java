package com.rovo.subscription_management.controller;


import com.rovo.subscription_management.model.Subscription;
import com.rovo.subscription_management.service.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
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


    /**
     * create new subscription
     * @param subscription
     * @return
     */

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




    /**
     * set plan for subscription
     * @param subscription_id
     * @param plan_id
     * @return ResponseEntity
     */

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

    /**
     * this method returning subscription list..
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @return list
     */

    @GetMapping("/")
    public ResponseEntity<List<Subscription>> getAllServices(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Subscription> list = subscriptionService.getAllServices(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Subscription>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @RequestMapping(path = "/csv")
    public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"employees.csv\"");
        subscriptionService.writeSubscriptionToCsv(servletResponse.getWriter());
    }


}
