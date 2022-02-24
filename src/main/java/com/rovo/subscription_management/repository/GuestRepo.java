package com.rovo.subscription_management.repository;

import com.rovo.subscription_management.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepo extends JpaRepository<Guest,Long> {

}
