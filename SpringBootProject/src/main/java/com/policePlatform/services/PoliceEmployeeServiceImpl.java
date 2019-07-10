package com.policePlatform.services;

import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.api.rest.dto.PoliceEmployeeSearchRequest;
import com.policePlatform.domain.model.PoliceEmployee;
import com.policePlatform.domain.repositories.PoliceEmployeeRepository;
import com.policePlatform.exceptions.NotFoundException;
import com.policePlatform.mapping.PoliceEmployeeMapper;
import com.policePlatform.services.specifications.PoliceEmployeeSearchSpecification;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PoliceEmployeeServiceImpl implements PoliceEmployeeService{

    PoliceEmployeeMapper policeEmployeeMapper;
    PoliceEmployeeRepository policeEmployeeRepository;
    PoliceEmployeeSearchSpecification policeEmployeeSearchSpecification;

    public PoliceEmployeeServiceImpl(PoliceEmployeeMapper policeEmployeeMapper,
            PoliceEmployeeRepository policeEmployeeRepository,
            PoliceEmployeeSearchSpecification policeEmployeeSearchSpecification){
        this.policeEmployeeMapper = policeEmployeeMapper;
        this.policeEmployeeRepository = policeEmployeeRepository;
        this.policeEmployeeSearchSpecification = policeEmployeeSearchSpecification;

    }
    @Override
    public PoliceEmployeeResponse createPoliceEmployee(PoliceEmployeeRequest request) {
        PoliceEmployee policeEmployee = policeEmployeeMapper.toEntity(request);
        return policeEmployeeMapper.toResponse(policeEmployeeRepository.save(policeEmployee));
    }

    @Override
    public PoliceEmployeeResponse getPoliceEmployee(Long id) {
        return policeEmployeeRepository.findById(id)
                .map(policeEmployeeMapper::toResponse).orElseThrow(NotFoundException::new);
    }

    @Override
    public PoliceEmployeeResponse updatePoliceEmployee(Long id, PoliceEmployeeRequest request) {
        PoliceEmployee entity = policeEmployeeRepository.findById(id).orElseThrow(NotFoundException::new);
        policeEmployeeMapper.updateEntity(entity, request);
        policeEmployeeRepository.save(entity);
        return policeEmployeeMapper.toResponse(entity);
    }

    @Override
    public void deletePoliceEmployee(Long id) {
        policeEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<PoliceEmployeeResponse> searchPoliceEmployee(PoliceEmployeeSearchRequest searchRequest, Pageable pageable) {
        return policeEmployeeRepository.findAll(policeEmployeeSearchSpecification.getSpecification(searchRequest), pageable)
                .map(policeEmployeeMapper::toResponse);
    }
}
