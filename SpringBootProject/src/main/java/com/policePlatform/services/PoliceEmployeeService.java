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
    PoliceEmployeeResponse createPoliceEmployee(PoliceEmployeeRequest request);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    PoliceEmployeeResponse getPoliceEmployee(Long id);

    ResponseEntity<JwtResponse> authenticateUser(LoginForm loginRequest);

    PoliceEmployeeResponse updatePoliceEmployee(Long id, PoliceEmployeeRequest request);

    void deletePoliceEmployee(Long id);

    Page<PoliceEmployeeResponse> searchPoliceEmployee(PoliceEmployeeSearchRequest searchRequest, Pageable pageable);
}
