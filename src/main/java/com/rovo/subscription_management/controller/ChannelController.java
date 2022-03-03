package com.rovo.subscription_management.controller;

import com.rovo.subscription_management.model.Channel;
import com.rovo.subscription_management.service.ChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController

@Slf4j
@RequestMapping("api/v1/channel")
public class ChannelController {

    private final ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping("/")
    public void addChannel(@Valid @RequestBody Channel channel){

        channelService.addChannel(channel);
    }

    @GetMapping("/")
    public List<Channel> findAllChannel(){
        return channelService.displayAllActiveChannel();
    }

}
