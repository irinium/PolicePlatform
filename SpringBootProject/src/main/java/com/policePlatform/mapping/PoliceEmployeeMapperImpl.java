package com.policePlatform.mapping;

import org.springframework.stereotype.Component;

import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.domain.model.PoliceEmployee;

@Component
public class PoliceEmployeeMapperImpl implements PoliceEmployeeMapper {
    @Override
    public PoliceEmployeeResponse toResponse(PoliceEmployee policeEmployee) {
        if (policeEmployee == null) {
            return null;
        }
        PoliceEmployeeResponse response = new PoliceEmployeeResponse();
        response.setId(policeEmployee.getId());
        response.setLastName(policeEmployee.getLastName());
        response.setName(policeEmployee.getName());
        return response;
    }

    @Override
    public PoliceEmployee toEntity(PoliceEmployeeRequest request) {
        PoliceEmployee employee = new PoliceEmployee();
        employee.setLastName(request.getLastName());
        employee.setName(request.getName());
        employee.setPassword(request.getPassword());
        return employee;
    }

    @Override
    public void updateEntity(PoliceEmployee entity, PoliceEmployeeRequest request) {
        entity.setLastName(request.getLastName());
        entity.setName(request.getName());
        entity.setPassword(request.getPassword());
    }
}
