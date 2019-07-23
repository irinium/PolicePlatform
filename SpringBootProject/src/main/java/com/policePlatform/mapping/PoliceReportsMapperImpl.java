package com.policePlatform.mapping;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.domain.model.PoliceReport;
import org.springframework.stereotype.Component;

@Component
public class PoliceReportsMapperImpl implements PoliceReportsMapper {

    @Override
    public PoliceReportResponse toResponse(PoliceReport policeReport) {
        PoliceReportResponse response = new PoliceReportResponse();
        response.setId(policeReport.getId());
        response.setAssignee(policeReport.getAssignee());
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
        report.setAssignee(request.getAssignee());
        report.setEo(request.getEo());
        report.setDecision(request.getDecision());
        report.setStory(request.getStory());
        report.setDeclarant(request.getDeclarant());
        report.setCommissionPlace(request.getCommissionPlace());
        report.setFullName(request.getFullName());
        report.setResults(request.getResults());
        return report;
    }

    @Override
    public void updateEntity(PoliceReport entity, PoliceReportRequest request) {
        entity.setAssignee(request.getAssignee());
        entity.setEo(request.getEo());
        entity.setDecision(request.getDecision());
        entity.setStory(request.getStory());
        entity.setDeclarant(request.getDeclarant());
        entity.setCommissionPlace(request.getCommissionPlace());
        entity.setFullName(request.getFullName());
        entity.setResults(request.getResults());
    }
}
