package com.rovo.subscription_management.controller;

import com.rovo.subscription_management.model.Guest;
import com.rovo.subscription_management.model.Hotel;
import com.rovo.subscription_management.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/hotels")
@Slf4j
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;


    @PostMapping("/")
    public ResponseEntity addNewHotel(@Valid @RequestBody Hotel hotel){

        try{
            hotelService.addHotel(hotel);
            log.info("{} Hotel Added "+hotel.getName());
            return new ResponseEntity(HttpStatus.CREATED);
        }

        catch (Exception exception){

            log.error("invalid request for adding new hotel ");
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping("/")
    public ResponseEntity<List<Hotel>> findAllHotel(){

        try{

            return new ResponseEntity<>(hotelService.findAllHotel(), HttpStatus.OK);

        }
        catch (Exception exception){

            log.error("invalid request for getting hotel data..");
            return  new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/{hotel_id}/subscriptions/{subscription_id}")
    ResponseEntity subscribePlan(@PathVariable("hotel_id") Long hotel_id,@PathVariable("subscription_id")Long subscription_id){

        try{

            hotelService.subscribeHotelService(hotel_id,subscription_id);
            log.info("Subscription Successfully Done...{}"+subscription_id);
            return new ResponseEntity(HttpStatus.OK);

        }
        catch (Exception exception){

            log.error("Bad request !! Unable to subscribe.. ");
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }
    @PostMapping("/{hotel_id}/guests/")
    ResponseEntity hotelNewGuest(@PathVariable("hotel_id")Long hotel_id, @RequestBody Guest guest){

        try{

            hotelService.newGuestEntry(hotel_id,guest);

            log.info("new guest entry as {}"+guest.getName());

            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception exception){

            log.error("bad request !! unable to add new guest.. ");
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
