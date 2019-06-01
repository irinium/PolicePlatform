package com.policePlatform.domain.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.policePlatform.domain.model.PoliceReport;

@Repository
public interface PoliceReportRepository extends CrudRepository<PoliceReport, Long>, JpaSpecificationExecutor<PoliceReport> {
}