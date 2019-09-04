package com.policePlatform.mapping;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.domain.model.PoliceReport;
import com.policePlatform.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PoliceReportsMapper {

    PoliceReportResponse toResponse(PoliceReport policeReport);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    PoliceReport toEntity(PoliceReportRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    PoliceReport updateEntity(@MappingTarget PoliceReport entity, PoliceReportRequest request);

    default String mapRoleName(Role role){
        return role.getRoleName();
    }
}
