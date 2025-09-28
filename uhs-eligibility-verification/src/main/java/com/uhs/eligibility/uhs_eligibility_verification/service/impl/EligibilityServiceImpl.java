package com.uhs.eligibility.uhs_eligibility_verification.service.impl;


import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityRequest;
import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityResponse;
import com.uhs.eligibility.uhs_eligibility_verification.entity.Patient;
import com.uhs.eligibility.uhs_eligibility_verification.mapper.PatientMapper;
import com.uhs.eligibility.uhs_eligibility_verification.repository.PatientRepository;
import com.uhs.eligibility.uhs_eligibility_verification.service.EligibilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EligibilityServiceImpl implements EligibilityService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public EligibilityServiceImpl(PatientRepository patientRepository,
                                  PatientMapper patientMapper) {

        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }


    @Override
    public EligibilityResponse checkEligibility(EligibilityRequest request) {
        log.info("Checking Eligibility for patient id :{}, provider: {}",
                request.getPatientId(), request.getInsuranceProvider());
        return patientRepository.findByIdAndInsuranceProvider(
                request.getPatientId(), request.getInsuranceProvider())
                .map(patient-> EligibilityResponse.builder()
                        .patientId(patient.getId())
                        .eligible(patient.isElligible())
                        .message(patient.isElligible()? "Eligible": "Not Eligible")
                .build())
                .orElse(EligibilityResponse.builder()
                        .patientId(request.getPatientId())
                        .message("Patient not found")
                        .eligible(false)
                        .build()

        );
    }

    @Override
    public Patient savePatient(EligibilityRequest request) {
        return patientRepository.save(patientMapper.toEntity(request));
    }
}
