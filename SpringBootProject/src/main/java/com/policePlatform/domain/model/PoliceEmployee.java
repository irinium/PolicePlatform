package com.policePlatform.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "police_employee")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PoliceEmployee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "UUID")
    String uuid;
    String name;
    @Column(name = "last_name")
    String lastName;
    String password;
    @ManyToMany
    @JoinTable(name = "employee_roles", joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;

}
