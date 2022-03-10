package com.rovo.subscription_management.service;

import com.rovo.subscription_management.model.Services;
import com.rovo.subscription_management.repository.ServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServicesService {

    private final ServiceRepo serviceRepo;

    public PlanServicesService(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    /**
     * add new service in DB
     * @param services
     */
    public void addNewService(Services services){

        serviceRepo.save(services);

    }

    /**
     * display all available service.
     * @return
     */
    public List<Services> findAllServices(){
        return serviceRepo.findAll();
    }

}
