package com.rovo.subscription_management.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 30)
    @NotNull
    private String name;



    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	@JoinColumn(name = "plan_id")
    private Set<Service> service;


    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	@JoinColumn(name = "plan_id")
    private Set<Channel> channel;


}
