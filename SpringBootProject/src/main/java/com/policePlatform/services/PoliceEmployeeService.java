package com.policePlatform.services;

import com.policePlatform.api.rest.dto.JwtResponse;
import com.policePlatform.api.rest.dto.LoginForm;
import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.api.rest.dto.PoliceEmployeeSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

public interface PoliceEmployeeService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    PoliceEmployeeResponse createPoliceEmployee(PoliceEmployeeRequest request);


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    PoliceEmployeeResponse addRole(Long id, PoliceEmployeeRequest request);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    PoliceEmployeeResponse getPoliceEmployee(Long id);

    ResponseEntity<JwtResponse> authenticateUser(LoginForm loginRequest);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    PoliceEmployeeResponse updatePoliceEmployee(Long id, PoliceEmployeeRequest request);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deletePoliceEmployee(Long id);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    Page<PoliceEmployeeResponse> searchPoliceEmployee(PoliceEmployeeSearchRequest searchRequest, Pageable pageable);
}
