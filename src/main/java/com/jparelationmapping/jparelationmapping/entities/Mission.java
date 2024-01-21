package com.jparelationmapping.jparelationmapping.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jpa_mission")
@Builder(setterPrefix = "with")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "missions")
  //  private Set<Employee> employees = new HashSet<>();
      private List<Employee> employees = new ArrayList<>();

}
