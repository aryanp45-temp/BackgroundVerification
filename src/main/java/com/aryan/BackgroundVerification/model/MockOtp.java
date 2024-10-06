package com.aryan.BackgroundVerification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MockOtp {

    @Id
    private String aadharNumber;
    private String phoneNumber;
    private String otp;

    @OneToOne
    @JoinColumn(name = "aadharNumber", referencedColumnName = "aadharNumber", insertable = false, updatable = false)
    private PersonalDetails personalDetails;
}