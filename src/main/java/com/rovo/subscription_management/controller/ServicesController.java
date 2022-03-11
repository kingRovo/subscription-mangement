package com.rovo.subscription_management.controller;

import com.rovo.subscription_management.model.Services;
import com.rovo.subscription_management.service.PlanServicesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/services")
public class ServicesController {

    private final PlanServicesService planServicesService;


    /**
     * add new service to Db
     * @param services
     * @return ResponseEntity
     */
    @PostMapping("/")
    public ResponseEntity addNewService(@Valid @RequestBody Services services){

        try{
            planServicesService.addNewService(services);

            log.info("new  Service :- {} added "+services.getName());

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * fetching all available service
     * @return ResponseEntity
     */
    @GetMapping("/")
    public ResponseEntity<List<Services>> findAllServices(){

        try{

            return new ResponseEntity<>(planServicesService.findAllServices(), HttpStatus.OK);
        }
        catch (Exception exception){

            log.error("Bad request! unable to fetch services");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
