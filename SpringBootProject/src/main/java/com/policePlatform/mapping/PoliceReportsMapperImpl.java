package com.policePlatform.mapping;

import org.springframework.stereotype.Component;

import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.domain.model.PoliceReport;
import com.policePlatform.exceptions.NotImplementedException;

@Component
public class PoliceReportsMapperImpl implements PoliceReportsMapper {
    @Override
    public PoliceReportResponse toResponse(PoliceReport policeReport) {
        throw new NotImplementedException();
    }
}
