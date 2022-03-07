package com.rovo.subscription_management.controller;

import com.rovo.subscription_management.model.Channel;
import com.rovo.subscription_management.service.ChannelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/channel")
public class ChannelController {

    private final ChannelService channelService;



    @PostMapping("/")
    public ResponseEntity addChannel(@Valid @RequestBody Channel channel){

        try{
            channelService.addChannel(channel);
            log.info("New Channel :- {} Added"+channel.getName());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception exception) {

            log.error("Bad request! unable to add channel");
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<Channel>> findAllChannel(){

        try {
            return new ResponseEntity<>(channelService.displayAllActiveChannel(), HttpStatus.OK);
        }
        catch (Exception exception){

            log.error("Bad Request! unable to fetch channels ");
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
