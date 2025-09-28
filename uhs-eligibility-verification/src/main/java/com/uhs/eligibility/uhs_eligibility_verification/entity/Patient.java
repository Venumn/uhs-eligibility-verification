package com.uhs.eligibility.uhs_eligibility_verification.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="patients")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @Column(length =50)
    private String id;

    @Column(nullable=false, length = 100)
    private String name;

    @Column(name="insurance_provider", nullable=false, length = 100)
    private String insuranceProvider;

    @Column(nullable = false)
    private boolean elligible;
}
