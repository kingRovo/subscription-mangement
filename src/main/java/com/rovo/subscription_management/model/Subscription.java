package com.rovo.subscription_management.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 10)
    private String name;

    @NotNull
    @Size(min = 5, max = 10)
    private String type;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expireDate;

    @NotNull
    private int usageLimit;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_id")
    private Plan plans;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id")
    private Set<Hotel> hotels;
}
