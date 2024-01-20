package com.jparelationmapping.jparelationmapping.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adrs_id")
    private Long addressId;
    private String city;
    private String addressType;



    @OneToOne(mappedBy = "address")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)

    private Employee employee;

}
