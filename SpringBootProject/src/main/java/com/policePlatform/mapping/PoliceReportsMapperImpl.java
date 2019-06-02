package com.policePlatform.mapping;

import org.springframework.stereotype.Component;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.domain.model.PoliceReport;

@Component
public class PoliceReportsMapperImpl implements PoliceReportsMapper {
    @Override
    public PoliceReportResponse toResponse(PoliceReport policeReport) {
        PoliceReportResponse response = new PoliceReportResponse();
        response.setEo(policeReport.getEo());
        response.setDecision(policeReport.getDecision());
        response.setStory(policeReport.getStory());
        response.setDeclarant(policeReport.getDeclarant());
        response.setCommissionPlace(policeReport.getCommissionPlace());
        response.setFullName(policeReport.getFullName());
        response.setResults(policeReport.getResults());
        return response;
    }

    @Override
    public PoliceReport toEntity(PoliceReportRequest request) {
        PoliceReport report = new PoliceReport();
        report.setEo(request.getEo());
        report.setDecision(request.getDecision());
        report.setStory(request.getStory());
        report.setDeclarant(request.getDeclarant());
        report.setCommissionPlace(request.getCommissionPlace());
        report.setFullName(request.getFullName());
        report.setResults(request.getResults());
        return report;
    }
}
