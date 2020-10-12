package com.policePlatform.mapping;

import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.domain.model.PoliceEmployee;
import com.policePlatform.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PoliceEmployeeMapper {

    List<String> toResponse(List<Role> roles);

    PoliceEmployeeResponse toResponse(PoliceEmployee policeEmployee);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "roles", ignore = true)
    PoliceEmployee toEntity(PoliceEmployeeRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "password", source = "encodedPassword")
    @Mapping(target = "roles", ignore = true)
    PoliceEmployee updateEntity(@MappingTarget PoliceEmployee entity, PoliceEmployeeRequest request,
        String encodedPassword);

    default String mapRoleName(Role role){
        return role.getRoleName();
    }
}
