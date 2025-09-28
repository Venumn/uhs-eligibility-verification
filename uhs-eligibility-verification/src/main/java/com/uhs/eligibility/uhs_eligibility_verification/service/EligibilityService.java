package com.uhs.eligibility.uhs_eligibility_verification.service;

import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityRequest;
import com.uhs.eligibility.uhs_eligibility_verification.dto.EligibilityResponse;
import com.uhs.eligibility.uhs_eligibility_verification.entity.Patient;

public interface EligibilityService {
    EligibilityResponse checkEligibility(EligibilityRequest request);

    Patient savePatient(EligibilityRequest request);
}
