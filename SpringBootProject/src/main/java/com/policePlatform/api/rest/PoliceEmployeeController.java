package com.policePlatform.api.rest;

import com.policePlatform.api.rest.dto.PoliceEmployeeRequest;
import com.policePlatform.api.rest.dto.PoliceEmployeeResponse;
import com.policePlatform.api.rest.dto.PoliceEmployeeSearchRequest;
import com.policePlatform.services.PoliceEmployeeService;
import com.policePlatform.services.PoliceReportService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/police-employee")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PoliceEmployeeController {
    PoliceEmployeeService policeEmployeeServise;

    @Autowired
    public PoliceEmployeeController(PoliceEmployeeService policeEmployeeServise) {
        this.policeEmployeeServise = policeEmployeeServise;
    }

    @PostMapping
    public PoliceEmployeeResponse createPoliceEmployee(@RequestBody PoliceEmployeeRequest request) {
        return policeEmployeeServise.createPoliceEmployee(request);
    }

    @GetMapping("/{id}")
    public PoliceEmployeeResponse getPoliceEmployee(@PathVariable("id") Long id) {
        return policeEmployeeServise.getPoliceEmployee(id);
    }

    @PutMapping("/{id}")
    public PoliceEmployeeResponse updatePoliceEmployee(@PathVariable("id") Long id,
                                                   @RequestBody PoliceEmployeeRequest request) {
        return policeEmployeeServise.updatePoliceEmployee(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePoliceEmployee(@PathVariable("id") Long id) {
        policeEmployeeServise.deletePoliceEmployee(id);
    }

    @GetMapping("/search")
    public Page<PoliceEmployeeResponse> search(PoliceEmployeeSearchRequest searchRequest, Pageable pageable) {
        return policeEmployeeServise.searchPoliceEmployee(searchRequest, pageable);
    }
}
