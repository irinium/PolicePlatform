package com.policePlatform.domain.repositories;

import com.policePlatform.domain.model.Permission;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PermissionRepository extends CrudRepository<Permission, Long> {

    Optional<Permission> findByPermissionName(String name);
}
