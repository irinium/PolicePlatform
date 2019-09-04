package com.policePlatform.domain.repositories;

import com.policePlatform.domain.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findByRoleNameIn(List<String> roleNames);
    List<Role> findByRoleName(List<String> roleNames);
}
