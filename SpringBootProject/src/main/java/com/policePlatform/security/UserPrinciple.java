package com.policePlatform.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.policePlatform.domain.model.PoliceEmployee;
import com.policePlatform.domain.model.Role;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserPrinciple implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String uuid;

    private String name;

    private String lastName;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> roles;

    public UserPrinciple(Long id, String uuid, String name, String lastName, String password,
        List<GrantedAuthority> roles) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.roles = roles;
    }

    public static UserPrinciple build(PoliceEmployee employee) {
        List<GrantedAuthority> role = employee.getRoles().stream()
            .map(Role::getRoleName)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        return new UserPrinciple(
            employee.getId(),
            employee.getUuid(),
            employee.getName(),
            employee.getLastName(),
            employee.getPassword(),
            role
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String getUsername() {
        return uuid;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}

