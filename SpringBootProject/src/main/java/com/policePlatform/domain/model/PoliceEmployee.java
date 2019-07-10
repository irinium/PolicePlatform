package com.policePlatform.domain.model;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "police_employee")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoliceEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;
    String password;

}
