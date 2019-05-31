package com.policePlatform.rest;

import com.policePlatform.model.PoliceReport;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class PoliceReports {

    @PostMapping("/api/v1/police-reports")
    public void addPolice(){

    }

    @GetMapping("/api/v1/police-reports/{id}")
    public void getPolice(){

    }

    @PutMapping("/api/v1/police-reports/{id}")
    public void renewalPolice(){

    }

    @DeleteMapping("/api/v1/police-reports/{id}")
    public void deletePolice()
    {

    }

    @Repository
    @Transactional
    public interface PoliceReportDAO extends CrudRepository<PoliceReport,Long>, JpaSpecificationExecutor<PoliceReport> {
    }
    @GetMapping("/api/v1/police-reports/search")
    public List<PoliceReport> findByCriteria(String policeReport){
        return policeReport.findAll(new Specification<PoliceReport>() {
            @Override
            public Predicate toPredicate(Root<PoliceReport> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        });
    }

}
