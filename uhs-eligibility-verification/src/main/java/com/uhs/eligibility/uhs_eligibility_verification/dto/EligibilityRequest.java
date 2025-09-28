package com.uhs.eligibility.uhs_eligibility_verification.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EligibilityRequest {

    @NotBlank(message = "Patient id is required")
    private String patientId;

    @NotBlank(message = "Insurance provider is required")
    private String insuranceProvider;

    @NotBlank(message = "Name is required")
    private String name;

    public boolean eligible;
}
