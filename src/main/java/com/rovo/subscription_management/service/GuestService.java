package com.rovo.subscription_management.service;

import com.rovo.subscription_management.model.Guest;
import com.rovo.subscription_management.repository.GuestRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepo guestRepo;

    GuestService(GuestRepo guestRepo){
        this.guestRepo = guestRepo;
    }

    public Guest addGuest(Guest guest){

        return guestRepo.save(guest);
    }
    public List<Guest> findAllGuest(){

        return guestRepo.findAll();
    }



}
