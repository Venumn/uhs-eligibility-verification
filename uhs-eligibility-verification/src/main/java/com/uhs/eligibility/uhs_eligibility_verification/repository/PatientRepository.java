package com.uhs.eligibility.uhs_eligibility_verification.repository;

import com.uhs.eligibility.uhs_eligibility_verification.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, String> {

    Optional<Patient>  findByIdAndInsuranceProvider(String id, String insuraneProvider);
}
