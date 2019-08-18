package com.policePlatform.services;

import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.api.rest.dto.PoliceEmployeeSearchRequest;
import com.policePlatform.domain.model.PoliceEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PoliceEmployeeService {
    PoliceEmployeeResponse createPoliceEmployee(PoliceEmployeeRequest request);

    PoliceEmployeeResponse getPoliceEmployee(Long id);

    PoliceEmployeeResponse getPoliceEmployeeUuid(String uuid);


    PoliceEmployeeResponse updatePoliceEmployee(Long id, PoliceEmployeeRequest request);

    void deletePoliceEmployee(Long id);

    Page<PoliceEmployeeResponse> searchPoliceEmployee(PoliceEmployeeSearchRequest searchRequest, Pageable pageable);
}
