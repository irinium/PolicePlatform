package com.policePlatform.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.api.rest.dto.PoliceReportSearchRequest;
import com.policePlatform.domain.repositories.PoliceReportRepository;
import com.policePlatform.exceptions.NotImplementedException;
import com.policePlatform.mapping.PoliceReportsMapper;
import com.policePlatform.services.specifications.PoliceReportSearchSpecification;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PoliceReportServiceImpl implements PoliceReportService {

    PoliceReportsMapper policeReportsMapper;
    PoliceReportRepository policeReportRepository;
    PoliceReportSearchSpecification policeReportSearchSpecification;

    @Autowired
    public PoliceReportServiceImpl(PoliceReportsMapper policeReportsMapper,
                                   PoliceReportRepository policeReportRepository,
                                   PoliceReportSearchSpecification policeReportSearchSpecification) {
        this.policeReportsMapper = policeReportsMapper;
        this.policeReportRepository = policeReportRepository;
        this.policeReportSearchSpecification = policeReportSearchSpecification;
    }

    @Override
    public PoliceReportResponse createPoliceReport(PoliceReportRequest request) {
        throw new NotImplementedException();
    }

    @Override
    public PoliceReportResponse getPoliceReport(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public PoliceReportResponse updatePoliceReport(Long id, PoliceReportRequest request) {
        throw new NotImplementedException();
    }

    @Override
    public void deletePoliceReport(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public Collection<PoliceReportResponse> searchPoliceReports(PoliceReportSearchRequest searchRequest) {
        return policeReportsMapper.toResponse(policeReportRepository.findAll(
                policeReportSearchSpecification.getSpecification(searchRequest)));
    }
}
