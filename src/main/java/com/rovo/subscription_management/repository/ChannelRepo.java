package com.rovo.subscription_management.repository;


import com.rovo.subscription_management.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepo extends JpaRepository<Channel,Long> {
}
