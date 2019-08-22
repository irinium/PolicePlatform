package com.policePlatform.api.rest.dto;

import com.policePlatform.domain.model.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoliceEmployeeResponse {
    Long id;
    String uuid;
    String name;
    String lastName;
    List<Role> roles;
}
