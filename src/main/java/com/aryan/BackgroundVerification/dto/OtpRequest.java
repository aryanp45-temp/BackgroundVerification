package com.aryan.BackgroundVerification.dto;

import lombok.Data;

@Data
public class OtpRequest {
    private String aadharNumber;
    private String otp;
}
