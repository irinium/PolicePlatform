package com.policePlatform.services.specifications;

import com.policePlatform.api.rest.dto.PoliceEmployeeSearchRequest;
import com.policePlatform.domain.model.PoliceEmployee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;
@Component
public class PoliceEmployeeSearchSpecification {
    public Specification<PoliceEmployee> getSpecification(PoliceEmployeeSearchRequest searchRequest) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            ofNullable(searchRequest.getLastName()).map(lastName -> criteriaBuilder.equal(root.get("last_name"), lastName)).ifPresent(predicates::add);
            ofNullable(searchRequest.getLastName()).map(name -> criteriaBuilder.equal(root.get("name"), name)).ifPresent(predicates::add);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
