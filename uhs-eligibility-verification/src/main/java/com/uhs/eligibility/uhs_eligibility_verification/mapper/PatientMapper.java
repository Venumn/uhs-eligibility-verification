package com.uhs.eligibility.uhs_eligibility_verification.mapper;

import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityRequest;
import com.uhs.eligibility.uhs_eligibility_verification.entity.Patient;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(EligibilityRequest dto) {
        return Patient.builder()
               .id(dto.getPatientId())
                .name(dto.getName())
                .insuranceProvider(dto.getInsuranceProvider())
                .elligible(dto.isEligible())
                .build();

    }
}
