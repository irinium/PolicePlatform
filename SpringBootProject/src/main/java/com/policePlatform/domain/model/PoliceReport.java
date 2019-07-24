package com.policePlatform.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "police_report")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoliceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "assignee", referencedColumnName = "id")
    PoliceEmployee assignee;
    Long eo;
    String decision;
    String story;
    String declarant;
    @Column(name = "commission_place")
    String commissionPlace;
    @Column(name = "full_name")
    String fullName;
    String results;
}
