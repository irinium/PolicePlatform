package com.policePlatform.security;

import com.policePlatform.domain.model.PoliceEmployee;
import com.policePlatform.domain.repositories.PoliceEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    PoliceEmployeeRepository policeEmployeeRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        PoliceEmployee user = policeEmployeeRepository.findByUuid(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                );

        return UserPrinciple.build(user);
    }
}
