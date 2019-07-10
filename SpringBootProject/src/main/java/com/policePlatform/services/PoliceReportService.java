package com.policePlatform.services;

import com.policePlatform.api.rest.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PoliceReportService {

    PoliceReportResponse createPoliceReport(PoliceReportRequest request);

    PoliceReportResponse getPoliceReport(Long id);

    PoliceReportResponse updatePoliceReport(Long id, PoliceReportRequest request);

    void deletePoliceReport(Long id);

    Page<PoliceReportResponse> searchPoliceReports(PoliceReportSearchRequest searchRequest, Pageable pageable);
}
