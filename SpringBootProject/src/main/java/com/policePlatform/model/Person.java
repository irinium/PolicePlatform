package com.policePlatform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "police_report_table")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long EO;
    private String decision;
    private String story;
    private String declarant;
    private String place_of_commission;
    private String full_name;
    private String results;
}
