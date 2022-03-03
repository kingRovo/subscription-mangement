package com.rovo.subscription_management.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 30)
    @NotNull
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "plan_channel",
            joinColumns = { @JoinColumn(name = "plan_id") },
            inverseJoinColumns = { @JoinColumn(name = "channel_id") }
    )
    Set<Channel> channels = new HashSet<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "plan_service",
            joinColumns = { @JoinColumn(name = "plan_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") }
    )
    Set<Services> services = new HashSet<>();

}
