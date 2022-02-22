package com.rovo.subscription_management.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.Date;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expireDate;

    @NotNull
    private int usageLimit;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plans_id")
    private Plan plans;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Set<Hotel> hotels;
}
