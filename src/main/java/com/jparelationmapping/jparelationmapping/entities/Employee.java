package com.jparelationmapping.jparelationmapping.entities;

import com.jparelationmapping.jparelationmapping.enums.TypeEmployee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_id")
    private Long employeeId;
    private String emp_firstName;
    private String emp_lastName;
    private Integer emp_age;

    //pour stocker  string pas 0,... ordinal dans la base des donnees
    @Enumerated(EnumType.STRING)
    private TypeEmployee typeEmployee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Fk_adrs_id")
    private Address address;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Experience> experiences ;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Mission> missions = new ArrayList<>();
}

