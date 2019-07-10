package com.policePlatform.api.rest.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoliceReportSearchRequest {

    Long assigneeId;
    Long eo;
    String decision;
    String story;
    String declarant;
    String commissionPlace;
    String fullName;
    String results;
}
