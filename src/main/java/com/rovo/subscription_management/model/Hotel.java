package com.rovo.subscription_management.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Hotel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 40)
    private String name;

    @NotNull
    @Size(min = 10, max = 60)
    private String address;

    @NotNull
    @Size(min = 7, max = 11)
    private String tel_num;

    @NotNull
    private int rating;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Set<Guest> guests;


}