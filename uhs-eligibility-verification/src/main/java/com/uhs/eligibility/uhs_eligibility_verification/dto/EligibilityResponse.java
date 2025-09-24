package com.uhs.eligibility.uhs_eligibility_verification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EligibilityResponse {

    private String patientId;
    private boolean eligible;
    private String message;
}
