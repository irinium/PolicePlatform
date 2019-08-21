package com.policePlatform.domain.repositories;

import com.policePlatform.domain.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);
}
