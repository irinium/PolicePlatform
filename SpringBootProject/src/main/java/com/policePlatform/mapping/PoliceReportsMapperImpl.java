package com.policePlatform.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.domain.model.PoliceReport;

@Component
public class PoliceReportsMapperImpl implements PoliceReportsMapper {

    private final PoliceEmployeeMapper policeEmployeeMapper;

    @Autowired
    public PoliceReportsMapperImpl(PoliceEmployeeMapper policeEmployeeMapper) {
        this.policeEmployeeMapper = policeEmployeeMapper;
    }

    @Override
    public PoliceReportResponse toResponse(PoliceReport policeReport) {
        PoliceReportResponse response = new PoliceReportResponse();
        response.setId(policeReport.getId());
        response.setAssignee(policeEmployeeMapper.toResponse(policeReport.getAssignee()));
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

    @Override
    public void updateEntity(PoliceReport entity, PoliceReportRequest request) {
        entity.setEo(request.getEo());
        entity.setDecision(request.getDecision());
        entity.setStory(request.getStory());
        entity.setDeclarant(request.getDeclarant());
        entity.setCommissionPlace(request.getCommissionPlace());
        entity.setFullName(request.getFullName());
        entity.setResults(request.getResults());
    }
}
