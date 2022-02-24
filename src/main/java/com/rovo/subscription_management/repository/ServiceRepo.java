package com.rovo.subscription_management.repository;


import com.rovo.subscription_management.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Long> {
}
