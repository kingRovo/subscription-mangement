package com.rovo.subscription_management.repository;

import com.rovo.subscription_management.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepo extends JpaRepository<Plan,Long> {

}
