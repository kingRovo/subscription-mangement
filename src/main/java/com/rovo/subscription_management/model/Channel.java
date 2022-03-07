package com.rovo.subscription_management.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
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

    @OneToMany(mappedBy = "channels", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
     private List<Plan> plans;
    @NotNull
    private Boolean isActive;

}
