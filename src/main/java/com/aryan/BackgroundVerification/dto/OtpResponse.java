package com.aryan.BackgroundVerification.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OtpResponse {
    public String photo;
    public String name;
    public String phoneNumber;
    public String gender;
    public String dob;
    public String address;
}
