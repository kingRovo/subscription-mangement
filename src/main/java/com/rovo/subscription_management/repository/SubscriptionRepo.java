package com.rovo.subscription_management.repository;

import com.rovo.subscription_management.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription,Long> {

}
