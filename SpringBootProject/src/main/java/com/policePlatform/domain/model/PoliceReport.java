package com.policePlatform.domain.model;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Import;
import org.springframework.data.annotation.Reference;

@Entity
@Table(name = "police_report")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoliceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.ALL)
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
