package com.policePlatform.services;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.api.rest.dto.PoliceReportSearchRequest;
import com.policePlatform.domain.model.PoliceReport;
import com.policePlatform.domain.repositories.PoliceReportRepository;
import com.policePlatform.exceptions.NotFoundException;
import com.policePlatform.mapping.PoliceReportsMapper;
import com.policePlatform.mapping.PoliceReportsMapperImpl;
import com.policePlatform.services.specifications.PoliceReportSearchSpecification;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PoliceReportServiceImpl implements PoliceReportService {

    PoliceReportsMapper policeReportsMapper;
    PoliceReportRepository policeReportRepository;
    PoliceReportSearchSpecification policeReportSearchSpecification;

    @Autowired
    public PoliceReportServiceImpl(PoliceReportRepository policeReportRepository,
        PoliceReportSearchSpecification policeReportSearchSpecification) {
        this.policeReportsMapper = new PoliceReportsMapperImpl();
        this.policeReportRepository = policeReportRepository;
        this.policeReportSearchSpecification = policeReportSearchSpecification;
    }

    @Override
    public PoliceReportResponse createPoliceReport(PoliceReportRequest request) {
        PoliceReport policeReport = policeReportsMapper.toEntity(request);
        return policeReportsMapper.toResponse(policeReportRepository.save(policeReport));
    }

    @Override
    public PoliceReportResponse getPoliceReport(Long id) {
        return policeReportRepository.findById(id)
            .map(policeReportsMapper::toResponse).orElseThrow(NotFoundException::new);
    }

    @Override
    public PoliceReportResponse updatePoliceReport(Long id, PoliceReportRequest request) {
        PoliceReport entity = policeReportRepository.findById(id).orElseThrow(NotFoundException::new);
        entity = policeReportsMapper.updateEntity(entity, request);
        policeReportRepository.save(entity);
        return policeReportsMapper.toResponse(entity);
    }

    @Override
    public void deletePoliceReport(Long id) {
        policeReportRepository.deleteById(id);
    }

    @Override
    public Page<PoliceReportResponse> searchPoliceReports(PoliceReportSearchRequest searchRequest, Pageable pageable) {
        return policeReportRepository.findAll(policeReportSearchSpecification.getSpecification(searchRequest), pageable)
            .map(policeReportsMapper::toResponse);
    }
}
