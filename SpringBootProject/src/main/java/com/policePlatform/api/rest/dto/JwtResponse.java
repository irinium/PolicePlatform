package com.policePlatform.api.rest.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtResponse {

    String token;
    String type = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }
}
