package com.rovo.subscription_management.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    private Long hotel_id;

    @NotNull
    @Size(min = 3, max = 7)
    private String gender;

    @NotNull
    @Size(min = 3, max = 30)
    private String city;
}
