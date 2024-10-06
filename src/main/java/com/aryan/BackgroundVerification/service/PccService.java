package com.aryan.BackgroundVerification.service;

import com.aryan.BackgroundVerification.Repository.PccDetailsRepository;
import com.aryan.BackgroundVerification.model.PccDetails;
import com.aryan.BackgroundVerification.util.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PccService {

    @Autowired
    PccDetailsRepository pccDetailsRepository;

    public boolean isPccVerified(String phoneNumber,String applicationId,String policeStationLocation){
        if(PhoneNumberValidator.isValidIndianPhoneNumber(phoneNumber)){
            Optional<PccDetails> pccDetails =  pccDetailsRepository.findById(applicationId);
            if (pccDetails.isPresent()){
                return applicationId.length()==15 && pccDetails.get().getApplicationId().equals(applicationId) && pccDetails.get().getPhoneNumber().equals(phoneNumber);
            }
        }
        return false;
    }

}
