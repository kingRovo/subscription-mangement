package com.rovo.subscription_management.service;

import com.rovo.subscription_management.model.Plan;
import com.rovo.subscription_management.repository.ChannelRepo;
import com.rovo.subscription_management.repository.PlanRepo;
import com.rovo.subscription_management.repository.ServiceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanService {

    private final PlanRepo planRepo;
    private final ServiceRepo serviceRepo;
    private final ChannelRepo channelRepo;

    /**
     * adding new plan to DB
     * @param plan
     */
    @Transactional
    public void addNewPlan(Plan plan){

        planRepo.save(plan);
    }

    /**
     * display all available plans
     * @return
     */
    public List<Plan> findAllPlan(){

        return  planRepo.findAll();
    }

    /**
     * adding service to a particular plan
     * @param plan_id
     * @param service_id
     */

    @Transactional
    public void addServiceToPlan(Long plan_id,Long service_id){

        if (!serviceRepo.getById(service_id).equals(null)) {
            Plan plan = planRepo.findById(plan_id).orElseThrow();
            plan.getService_id().add(service_id);
            planRepo.save(plan);
        }
    }

    /**
     * adding channel to plan at given plan_ID
     * @param plan_id
     * @param channel_id
     */
    @Transactional
    public void addChannelToPlan(Long plan_id,Long channel_id){

        if(!channelRepo.getById(channel_id).equals(null)) {
            Plan plan = planRepo.findById(plan_id).orElseThrow();
            plan.getChannel_id().add(channel_id);
            planRepo.save(plan);
        }


    }
}
