package com.policePlatform.api.rest.dto;

import com.policePlatform.domain.model.PoliceEmployee;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoliceReportRequest {
    Long eo;
    PoliceEmployee assignee;
    String decision;
    String story;
    String declarant;
    String commissionPlace;
    String fullName;
    String results;
}
