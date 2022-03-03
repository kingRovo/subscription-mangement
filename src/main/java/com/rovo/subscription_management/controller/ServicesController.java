package com.rovo.subscription_management.controller;


import com.rovo.subscription_management.model.Services;
import com.rovo.subscription_management.service.PlanService;
import com.rovo.subscription_management.service.PlanServicesService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Services")
public class ServicesController {

    private final PlanServicesService planServicesService;

    public ServicesController(PlanServicesService planServicesService) {
        this.planServicesService = planServicesService;
    }

    @PostMapping("/")
    public void addNewService(@Valid @RequestBody Services services){
        planServicesService.addNewService(services);
    }

    @GetMapping("/")
    public List<Services> findAllServices(){
        return planServicesService.findAllServices();
    }

}
