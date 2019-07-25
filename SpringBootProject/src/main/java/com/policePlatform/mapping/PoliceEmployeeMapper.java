package com.policePlatform.mapping;


import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.domain.model.PoliceEmployee;

import java.util.Collection;
import java.util.stream.Collectors;

public interface PoliceEmployeeMapper {
    PoliceEmployeeResponse toResponse(PoliceEmployee policeEmployee);

    default Collection<PoliceEmployeeResponse> toResponse(Collection<PoliceEmployee> employees) {
        return employees.stream().map(this::toResponse).collect(Collectors.toList());
    }

    PoliceEmployee toEntity(PoliceEmployeeRequest request);

    void updateEntity(PoliceEmployee entity, PoliceEmployeeRequest request);
}
