package com.policePlatform.api.rest;

import com.policePlatform.api.rest.dto.JwtResponse;
import com.policePlatform.api.rest.dto.LoginForm;
import com.policePlatform.domain.model.PoliceEmployee;
import com.policePlatform.domain.repositories.PoliceEmployeeRepository;
import com.policePlatform.security.jwt.JwtProvider;
import com.policePlatform.services.PoliceEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    PoliceEmployeeService policeEmployeeService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        return policeEmployeeService.authenticateUser(loginRequest);

    }


}
