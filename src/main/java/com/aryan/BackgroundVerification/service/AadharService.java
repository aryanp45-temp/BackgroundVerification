package com.aryan.BackgroundVerification.service;

import com.aryan.BackgroundVerification.Repository.MockOtpRepository;
import com.aryan.BackgroundVerification.Repository.PersonalDetailsRepository;
import com.aryan.BackgroundVerification.dto.GeneratedOtp;
import com.aryan.BackgroundVerification.dto.OtpErrorResponse;
import com.aryan.BackgroundVerification.dto.OtpResponse;
import com.aryan.BackgroundVerification.model.MockOtp;
import com.aryan.BackgroundVerification.model.PersonalDetails;
import com.aryan.BackgroundVerification.util.AadhaarValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AadharService {

    @Autowired
    PersonalDetailsRepository personalDetailsRepository;

    @Autowired
    MockOtpRepository mockOtpRepository;

    public boolean isAadharNumberValid(String aadharNumber) {
        if(AadhaarValidator.isValidAadhaarNumber(aadharNumber)){
            return personalDetailsRepository.existsById(aadharNumber);
        }else return false;
    }

    public Object verifyOtp(String aadharNumber, String otp) {
        if(AadhaarValidator.isValidAadhaarNumber(aadharNumber) &&
                personalDetailsRepository.existsById(aadharNumber)) {
            // check if OTP matches
            MockOtp mockOtp = mockOtpRepository.findById(aadharNumber).get();
            if (mockOtp.getOtp().equals(otp)) {
                // return personal details
                PersonalDetails personalDetails = personalDetailsRepository.findById(aadharNumber).get();

                return OtpResponse.builder()
                        .photo(personalDetails.getPhoto())
                        .name(personalDetails.getName())
                        .phoneNumber(mockOtp.getPhoneNumber())
                        .gender(personalDetails.getGender())
                        .dob(personalDetails.getDob())
                        .address(personalDetails.getAddress())
                        .build();
            }
        }

        return new OtpErrorResponse("Incorrect OTP !!");
    }

    public Object generateOtp(String aadhar){
        if (AadhaarValidator.isValidAadhaarNumber(aadhar) &&
                personalDetailsRepository.existsById(aadhar)){
            MockOtp mockOtp = mockOtpRepository.findById(aadhar).get();
            return GeneratedOtp.builder()
                    .otp(mockOtp.getOtp())
                    .build();
        }
        return new OtpErrorResponse("Invalid Aaadhar Number !!");
    }

}
