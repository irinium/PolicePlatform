package com.policePlatform.mapping;


import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.domain.model.PoliceEmployee;
import java.util.Collection;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PoliceEmployeeMapper {

    PoliceEmployeeResponse toResponse(PoliceEmployee policeEmployee);

    default Collection<PoliceEmployeeResponse> toResponse(Collection<PoliceEmployee> employees) {
        return employees.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", expression = "java(java.util.UUID.randomUUID().toString())")
    PoliceEmployee toEntity(PoliceEmployeeRequest request);

    default PoliceEmployee updateEntity(PoliceEmployee entity, PoliceEmployeeRequest request, String encodedPassword) {
        entity.setLastName(request.getLastName());
        entity.setName(request.getName());
        entity.setPassword(encodedPassword);
        return entity;
    }
}
