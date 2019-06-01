package com.policePlatform.mapping;

import java.util.Collection;
import java.util.stream.Collectors;

import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.domain.model.PoliceReport;

public interface PoliceReportsMapper {

    PoliceReportResponse toResponse(PoliceReport policeReport);

    default Collection<PoliceReportResponse> toResponse(Collection<PoliceReport> reports) {
        return reports.stream().map(this::toResponse).collect(Collectors.toList());
    }
}