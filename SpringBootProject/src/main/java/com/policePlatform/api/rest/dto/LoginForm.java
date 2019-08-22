package com.policePlatform.api.rest.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginForm {

    @NotBlank
    String uuid;
    @NotBlank
    String password;
}
