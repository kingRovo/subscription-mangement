package com.rovo.subscription_management.service;

import com.rovo.subscription_management.model.Guest;
import com.rovo.subscription_management.model.Hotel;

import com.rovo.subscription_management.repository.GuestRepo;
import com.rovo.subscription_management.repository.HotelRepo;
import com.rovo.subscription_management.repository.SubscriptionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelService {


    private final HotelRepo hotelRepo;

    private final SubscriptionRepo subscriptionRepo;

    private final GuestRepo guestRepo;


    public Hotel addHotel(Hotel hotel){

        return hotelRepo.save(hotel);

    }
    public List<Hotel> findAllHotel(){

        return hotelRepo.findAll();
    }


    public void subscribeHotelService(Long hotel_id,Long subscription_id)throws NullPointerException{

        if(!subscriptionRepo.getById(subscription_id).equals(null)){

            Hotel hotel = hotelRepo.findById(hotel_id).orElseThrow();

            hotel.setSubscription_id(subscription_id);

            hotelRepo.save(hotel);
        }

    }


    public void newGuestEntry(Long hotel_id, Guest guest){

        if(!hotelRepo.getById(hotel_id).equals(null)){
        guest.setHotel_id(hotel_id);
        guestRepo.save(guest);
        }

    }
}
