package com.policePlatform.mapping;

import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.domain.model.PoliceEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PoliceEmployeeMapper {

    PoliceEmployeeResponse toResponse(PoliceEmployee policeEmployee);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", expression = "java(java.util.UUID.randomUUID().toString())")
    PoliceEmployee toEntity(PoliceEmployeeRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "password", source = "encodedPassword")
    PoliceEmployee updateEntity(@MappingTarget PoliceEmployee entity, PoliceEmployeeRequest request,
        String encodedPassword);
}
