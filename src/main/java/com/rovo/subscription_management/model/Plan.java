package com.rovo.subscription_management.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;



    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	@JoinColumn(name = "service_id")
    private Set<Service> service;


    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	@JoinColumn(name = "channel_id")
    private Set<Channel> channel;


}
