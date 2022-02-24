package com.rovo.subscription_management.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Channel {

    @Id
    @Size(min = 3, max = 15)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 30)
    private String name;
    @NotNull
    @Size(min = 5, max = 30)
    private String type;

    @NotNull
    private Boolean isActive;

}
