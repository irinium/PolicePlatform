package com.policePlatform.mapping;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.domain.model.PoliceReport;
import java.util.Collection;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PoliceReportsMapper {

    PoliceReportResponse toResponse(PoliceReport policeReport);

    default Collection<PoliceReportResponse> toResponse(Collection<PoliceReport> reports) {
        return reports.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    PoliceReport toEntity(PoliceReportRequest request);

    default PoliceReport updateEntity(PoliceReport entity, PoliceReportRequest request) {
        entity.setEo(request.getEo());
        entity.setDecision(request.getDecision());
        entity.setStory(request.getStory());
        entity.setDeclarant(request.getDeclarant());
        entity.setCommissionPlace(request.getCommissionPlace());
        entity.setFullName(request.getFullName());
        entity.setResults(request.getResults());
        return entity;
    }
}
