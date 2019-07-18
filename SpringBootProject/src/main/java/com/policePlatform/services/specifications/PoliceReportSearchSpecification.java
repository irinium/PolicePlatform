package com.policePlatform.services.specifications;

import com.policePlatform.api.rest.dto.PoliceReportSearchRequest;
import com.policePlatform.domain.model.PoliceReport;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class PoliceReportSearchSpecification {
    public Specification<PoliceReport> getSpecification(PoliceReportSearchRequest searchRequest) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            ofNullable(searchRequest.getEo()).map(eo -> criteriaBuilder.equal(root.get("eo"), eo)).ifPresent(predicates::add);
            ofNullable(searchRequest.getDecision()).map(decision -> criteriaBuilder.equal(root.get("decision"), decision)).ifPresent(predicates::add);
            ofNullable(searchRequest.getStory()).map(story -> criteriaBuilder.equal(root.get("story"), story)).ifPresent(predicates::add);
            ofNullable(searchRequest.getDeclarant()).map(declarant -> criteriaBuilder.equal(root.get("declarant"), declarant)).ifPresent(predicates::add);
            ofNullable(searchRequest.getCommissionPlace()).map(commissionPlace -> criteriaBuilder.equal(root.get("commission_place"), commissionPlace)).ifPresent(predicates::add);
            ofNullable(searchRequest.getFullName()).map(fullName -> criteriaBuilder.equal(root.get("full_name"), fullName)).ifPresent(predicates::add);
            ofNullable(searchRequest.getResults()).map(results -> criteriaBuilder.equal(root.get("results"), results)).ifPresent(predicates::add);
            ofNullable(searchRequest.getAssigneeId()).map(assigneeId -> criteriaBuilder.equal(root.join("assignee_id"), assigneeId)).ifPresent(predicates::add);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}