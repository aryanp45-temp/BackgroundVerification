package com.aryan.BackgroundVerification.controller;

import com.aryan.BackgroundVerification.dto.AadharRequest;
import com.aryan.BackgroundVerification.dto.OtpRequest;
import com.aryan.BackgroundVerification.dto.VerifyResponse;
import com.aryan.BackgroundVerification.service.AadharService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aadhar")
@Slf4j
public class AadharController {

    @Autowired
    AadharService aadharService;

    @PostMapping("/verify")
    public ResponseEntity<?> verifyAadhar(@RequestBody AadharRequest request){
        String aadharNumber = request.getAadharNumber();
        log.info("Aadhar Number being Verified is : {}", aadharNumber);
        VerifyResponse verifyResponse = new VerifyResponse(aadharService.isAadharNumberValid(aadharNumber));
        return ResponseEntity.ok(verifyResponse);
    }

    @PostMapping("/otp")
    public ResponseEntity<?> verifyOtp(@RequestBody OtpRequest otpRequest){
        return ResponseEntity.ok(aadharService.verifyOtp(otpRequest.getAadharNumber(),otpRequest.getOtp()));
    }

    @PostMapping("/generateOtp")
    public ResponseEntity<?> generateOtp(@RequestBody AadharRequest aadharRequest ){
        return ResponseEntity.ok(aadharService.generateOtp(aadharRequest.getAadharNumber()));
    }

}
