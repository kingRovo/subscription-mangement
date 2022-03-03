package com.rovo.subscription_management.service;

import com.rovo.subscription_management.model.Channel;
import com.rovo.subscription_management.model.Plan;
import com.rovo.subscription_management.model.Services;
import com.rovo.subscription_management.repository.ChannelRepo;
import com.rovo.subscription_management.repository.PlanRepo;
import com.rovo.subscription_management.repository.ServiceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanService {

    private final PlanRepo planRepo;
    private final ServiceRepo serviceRepo;
    private final ChannelRepo channelRepo;

    public void addNewPlan(Plan plan){

        planRepo.save(plan);
    }
    public List<Plan> findAllPlan(){

        return  planRepo.findAll();
    }

    public void addServiceToPlan(Long plan_id,Services services){

        Plan plan = planRepo.findById(plan_id).orElseThrow();
        plan.getServices().add(services);
        planRepo.save(plan);
    }
    public void addChannelToPlan(Long plan_id,Channel channel){

        Plan plan = planRepo.findById(plan_id).orElseThrow();
        plan.getChannels().add(channel);
        planRepo.save(plan);
    }
}
