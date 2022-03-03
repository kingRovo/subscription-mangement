package com.rovo.subscription_management.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;
    @NotNull
    @Size(min = 3, max = 30)
    private String type;

    @ManyToMany(mappedBy = "channels")
    private Set<Plan> plans = new HashSet<>();


    @NotNull
    private Boolean isActive;

}
