package com.rovo.subscription_management.service;

import com.rovo.subscription_management.model.Channel;
import com.rovo.subscription_management.repository.ChannelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    private final ChannelRepo channelRepo;

    ChannelService(ChannelRepo channelRepo){
        this.channelRepo = channelRepo;
    }

    /**
     * save new channel to DB
     * @param channel
     * @return
     */
    public Channel addChannel(Channel channel){

        return channelRepo.save(channel);

    }

    /**
     * Display all channel form database
     * @return
     */
    public List<Channel> displayAllActiveChannel(){

        return channelRepo.findAll();

    }
}
