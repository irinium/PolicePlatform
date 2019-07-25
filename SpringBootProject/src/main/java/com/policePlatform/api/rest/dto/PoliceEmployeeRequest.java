package com.policePlatform.api.rest.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoliceEmployeeRequest {
    String name;
    String lastName;
    String password;
}
