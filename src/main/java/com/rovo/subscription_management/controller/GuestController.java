package com.rovo.subscription_management.controller;


import com.rovo.subscription_management.model.Guest;
import com.rovo.subscription_management.service.GuestService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/guests")
public class GuestController {

    private final GuestService guestService;



    public GuestController( GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/")
    public void addNewGuest(@Valid @RequestBody Guest guest){

        guestService.addGuest(guest);
    }

    @GetMapping("/")
    public List<Guest> DisplayAllGuest(){
        return guestService.findAllGuest();
    }
}
