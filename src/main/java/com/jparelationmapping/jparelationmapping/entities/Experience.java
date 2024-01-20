package com.jparelationmapping.jparelationmapping.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jpa_experience")
@Builder(setterPrefix = "with")

public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profession;
    private String compagnie;

    @ManyToOne
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @JoinColumn(name = "FK_emp_id")
    private Employee employee;


}
