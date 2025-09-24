package com.uhs.eligibility.uhs_eligibility_verification.service.impl;


import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityRequest;
import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityResponse;
import com.uhs.eligibility.uhs_eligibility_verification.repository.PatientRepository;
import com.uhs.eligibility.uhs_eligibility_verification.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final PatientRepository patientRepository;

    public EligibilityServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public EligibilityResponse checkEligibility(EligibilityRequest request) {
        return patientRepository.findByIdAndInsuranceProvider(
                request.getPatientId(), request.getInsuranceProvider())
                .map(patient-> EligibilityResponse.builder()
                        .patientId(patient.getId())
                        .eligible(patient.isElligible())
                        .message(patient.isElligible()? "Eligible": "Not Elligible")
                .build())
                .orElse(EligibilityResponse.builder()
                        .patientId(request.getPatientId())
                        .message("Patient not found")
                        .eligible(false)
                        .build()

        );
    }
}
