package com.policePlatform.domain.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
