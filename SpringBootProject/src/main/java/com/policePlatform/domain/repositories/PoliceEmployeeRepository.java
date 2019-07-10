package com.policePlatform.domain.repositories;

import com.policePlatform.domain.model.PoliceEmployee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceEmployeeRepository extends CrudRepository<PoliceEmployee, Long>, JpaSpecificationExecutor<PoliceEmployee> {
}
