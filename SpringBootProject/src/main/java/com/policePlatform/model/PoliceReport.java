package com.policePlatform.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "police_report")
@Data
public class PoliceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long EO;
    private String decision;
    private String story;
    private String declarant;
    @Column(name = "commission_place")
    private String commisionPlace;
    @Column(name = "full_name")
    private String fullName;
    private String results;
}
