package com.rovo.subscription_management.repository;

import com.rovo.subscription_management.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Long> {
}
