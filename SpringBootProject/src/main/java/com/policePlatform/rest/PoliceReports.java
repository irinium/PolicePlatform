package com.policePlatform.rest;

import com.policePlatform.model.PoliceReport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PoliceReports {

    @PostMapping("/api/v1/police-reports")
    public void addPolice(){

    }

    @GetMapping("/api/v1/police-reports/{id}")
    public void getPolice(){

    }

    @PutMapping("/api/v1/police-reports/{id}")
    public void renewalPolice(){

    }

    @DeleteMapping("/api/v1/police-reports/{id}")
    public void deletePolice()
    {

    }

    @GetMapping("/api/v1/police-reports/search")
    public ResponseEntity<Set<PoliceReport>> searchPoliceReports(@RequestParam(value = "id", required = false) String idVal,
                                                            @RequestParam(value = "EO", required = false) String EOVal,
                                                            @RequestParam(value = "decision", required = false) String decisionVal,
                                                            @RequestParam(value = "story", required = false) String storyVal,
                                                            @RequestParam(value = "declarant", required = false) String declarantVal,
                                                            @RequestParam(value = "commisionPlace", required = false) String commisionPlaceVal,
                                                            @RequestParam(value = "fullName", required = false) String fullNameVal,
                                                            @RequestParam(value = "results", required = false) String resultsVal) {}

}
