package com.uhs.eligibility.uhs_eligibility_verification.controller;

import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityRequest;
import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityResponse;
import com.uhs.eligibility.uhs_eligibility_verification.entity.Patient;
import com.uhs.eligibility.uhs_eligibility_verification.service.EligibilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class EligibilityController {
    private final EligibilityService eligibilityService;

    @PostMapping("/eligibility")
    public ResponseEntity<EligibilityResponse> checkEligibility(@Valid @RequestBody
                                                                EligibilityRequest request){
        return  ResponseEntity.ok(eligibilityService.checkEligibility(request));
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(
            @Valid @RequestBody EligibilityRequest request
    ) {
       Patient saved =  eligibilityService.savePatient(request);
       return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


}
