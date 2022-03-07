package com.rovo.subscription_management.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;



@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 30)
    @NotNull
    private String name;

    @ElementCollection
    private Set<Long> channel_id;

    @ElementCollection
    private Set<Long> service_id;


}
