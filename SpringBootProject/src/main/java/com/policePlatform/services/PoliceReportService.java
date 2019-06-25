package com.policePlatform.services;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.api.rest.dto.PoliceReportSearchRequest;
import java.util.Collection;

public interface PoliceReportService {

    PoliceReportResponse createPoliceReport(PoliceReportRequest request);

    PoliceReportResponse getPoliceReport(Long id);

    PoliceReportResponse updatePoliceReport(Long id, PoliceReportRequest request);

    void deletePoliceReport(Long id);

    Collection<PoliceReportResponse> searchPoliceReports(PoliceReportSearchRequest searchRequest);
}
