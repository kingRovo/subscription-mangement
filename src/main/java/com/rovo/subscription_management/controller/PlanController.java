package com.rovo.subscription_management.controller;

import com.rovo.subscription_management.model.Channel;
import com.rovo.subscription_management.model.Plan;
import com.rovo.subscription_management.model.Services;
import com.rovo.subscription_management.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/plans")
public class PlanController {

    private final PlanService planService;

    PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/")
    public ResponseEntity addNewPlan(@Valid @RequestBody Plan plan){
        try{
            planService.addNewPlan(plan);
            log.info("New plan added..");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception exception){

            log.error("Invalid request to add new plan");
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/")
    ResponseEntity<List<Plan>> findAllPlan(){
        try {
            return new ResponseEntity<>(planService.findAllPlan(), HttpStatus.OK);

        }
        catch (Exception exception){

            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/{plan_id}/channel")
    ResponseEntity addNewChannel(@PathVariable("plan_id") Long plan_id, Channel channel){

        try{


            planService.addChannelToPlan(plan_id,channel);

            log.info("New Channel linked with plan {}"+plan_id);
            return new ResponseEntity<>(HttpStatus.OK);

        }

        catch (Exception exception){

            log.error("invalid request");
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    @PostMapping("/{plan_id}/service")
    ResponseEntity addNewService(@PathVariable("plan_id") Long plan_id, Services services){

        try{


            planService.addServiceToPlan(plan_id,services);

            log.info("New Service linked with plan {}"+plan_id);
            return new ResponseEntity<>(HttpStatus.OK);

        }

        catch (Exception exception){

            log.error("invalid request");
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
