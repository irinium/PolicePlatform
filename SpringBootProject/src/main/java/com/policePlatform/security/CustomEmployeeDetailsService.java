package com.policePlatform.security;

import com.policePlatform.domain.repositories.PoliceEmployeeRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomEmployeeDetailsService implements UserDetailsService {

    PoliceEmployeeRepository policeEmployeeRepository;

    @Autowired
    public CustomEmployeeDetailsService(PoliceEmployeeRepository policeEmployeeRepository){
        this.policeEmployeeRepository = policeEmployeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {

       return this.policeEmployeeRepository.findByUuid(uuid).orElseThrow(() ->
               new UsernameNotFoundException("Username: " + uuid + " not found"));

    }
}
