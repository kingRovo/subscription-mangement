package com.rovo.subscription_management.repository;


import com.rovo.subscription_management.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Services,Long> {
}
