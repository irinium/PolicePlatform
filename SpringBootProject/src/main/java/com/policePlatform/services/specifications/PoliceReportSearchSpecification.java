package com.policePlatform.services.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.policePlatform.api.rest.dto.PoliceReportSearchRequest;
import com.policePlatform.domain.model.PoliceReport;
import com.policePlatform.exceptions.NotImplementedException;

@Component
public class PoliceReportSearchSpecification {
    public Specification<PoliceReport> getSpecification(PoliceReportSearchRequest searchRequest) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            throw new NotImplementedException();
        };
    }
}
