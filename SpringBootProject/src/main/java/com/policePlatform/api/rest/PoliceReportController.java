package com.policePlatform.api.rest;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.api.rest.dto.PoliceReportSearchRequest;
import com.policePlatform.services.PoliceReportService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/police-reports")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PoliceReportController {

    PoliceReportService policeReportService;

    @Autowired
    public PoliceReportController(PoliceReportService policeReportService) {
        this.policeReportService = policeReportService;
    }

    @PostMapping
    public PoliceReportResponse createPoliceReport(@RequestBody PoliceReportRequest request) {
        return policeReportService.createPoliceReport(request);
    }

    @GetMapping("/{id}")
    public PoliceReportResponse getPoliceReport(@PathVariable("id") Long id) {
        return policeReportService.getPoliceReport(id);
    }

    @PutMapping("/{id}")
    public PoliceReportResponse updatePoliceReport(@PathVariable("id") Long id,
        @RequestBody PoliceReportRequest request) {
        return policeReportService.updatePoliceReport(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePoliceReport(@PathVariable("id") Long id) {
        policeReportService.deletePoliceReport(id);
    }

    @GetMapping("/search")
    public Page<PoliceReportResponse> search(PoliceReportSearchRequest searchRequest, Pageable pageable) {
        return policeReportService.searchPoliceReports(searchRequest, pageable);
    }


}
