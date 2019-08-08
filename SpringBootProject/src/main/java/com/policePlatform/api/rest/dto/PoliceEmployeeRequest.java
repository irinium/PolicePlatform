package com.policePlatform.api.rest.dto;

import com.policePlatform.domain.model.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoliceEmployeeRequest {
    String name;
    String lastName;
    String password;
    List<Role> roles;
}
