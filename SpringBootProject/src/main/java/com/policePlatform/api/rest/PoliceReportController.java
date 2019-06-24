package com.policePlatform.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.api.rest.dto.PoliceReportSearchRequest;
import com.policePlatform.exceptions.NotImplementedException;
import com.policePlatform.services.PoliceReportService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController("/api/v1/police-reports")
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
        return  policeReportService.getPoliceReport(id);
    }

    @PutMapping("/{id}")
    public PoliceReportResponse updatePoliceReport(@PathVariable("id") Long id, @RequestBody PoliceReportRequest request) {
        return policeReportService.updatePoliceReport(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePoliceReport(@PathVariable("id") Long id) {
        policeReportService.deletePoliceReport(id);
    }

    @GetMapping("/search")
    public List<PoliceReportResponse> search(PoliceReportSearchRequest searchRequest) {
        throw new NotImplementedException();
    }
}
