package com.policePlatform.services;

import com.policePlatform.api.rest.dto.LoginForm;
import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.api.rest.dto.PoliceEmployeeSearchRequest;
import com.policePlatform.domain.model.PoliceEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface PoliceEmployeeService {
    PoliceEmployeeResponse createPoliceEmployee(PoliceEmployeeRequest request);

    @PreAuthorize("hasRole('ADMIN_ROLE')")
    PoliceEmployeeResponse getPoliceEmployee(Long id);

    ResponseEntity<?> authenticateUser(LoginForm loginRequest);

    PoliceEmployeeResponse updatePoliceEmployee(Long id, PoliceEmployeeRequest request);

    void deletePoliceEmployee(Long id);

    Page<PoliceEmployeeResponse> searchPoliceEmployee(PoliceEmployeeSearchRequest searchRequest, Pageable pageable);
}
