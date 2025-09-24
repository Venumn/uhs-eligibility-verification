package com.uhs.eligibility.uhs_eligibility_verification.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EligibilityRequest {

    @NotBlank
    private String patientId;

    @NotBlank
    private String insuranceProvider;
}
