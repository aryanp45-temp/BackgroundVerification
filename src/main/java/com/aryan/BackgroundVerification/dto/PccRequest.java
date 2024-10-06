package com.aryan.BackgroundVerification.dto;

import lombok.Data;

@Data
public class PccRequest {
    private String phoneNumber;
    private String applicationId;       // 15 digits long and is an alpha-numeric string
    private String policeStationLocation;
}
