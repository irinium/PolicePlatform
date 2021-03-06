package com.policePlatform.domain.repositories;

import com.policePlatform.domain.model.PoliceEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoliceEmployeeRepository extends CrudRepository<PoliceEmployee, Long>, JpaSpecificationExecutor<PoliceEmployee> {

    Optional<PoliceEmployee> findByUuid(String uuid);
    boolean existsByUuid(String uuid);
}
