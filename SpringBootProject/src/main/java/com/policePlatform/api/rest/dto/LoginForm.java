package com.policePlatform.api.rest.dto;

import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginForm {

    @NotBlank
    String uuid;
    @NotBlank
    String password;
}
