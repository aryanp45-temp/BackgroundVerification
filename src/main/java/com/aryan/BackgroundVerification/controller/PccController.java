package com.aryan.BackgroundVerification.controller;

import com.aryan.BackgroundVerification.dto.PccRequest;
import com.aryan.BackgroundVerification.dto.VerifyResponse;
import com.aryan.BackgroundVerification.service.PccService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/pcc")
public class PccController {

    @Autowired
    PccService pccService;

    @PostMapping("/verify")
    public ResponseEntity<?> isPccVerified(@RequestBody PccRequest pccRequest){
        VerifyResponse verifyResponse = new VerifyResponse(pccService.isPccVerified(pccRequest.getPhoneNumber(),pccRequest.getApplicationId(),pccRequest.getPoliceStationLocation()));
        return ResponseEntity.ok(verifyResponse);
    }

}
