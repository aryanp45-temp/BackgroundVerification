package com.aryan.BackgroundVerification.util;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class PhoneNumberValidator {

    public static boolean isValidIndianPhoneNumber(String phoneNumber) {
        String regex = "^(\\+91|91|0)?[6-9][0-9]{9}$";

        Pattern p = Pattern.compile(regex);

        if (phoneNumber == null) {
            return false;
        }

        Matcher m = p.matcher(phoneNumber);

        return m.matches();
    }

}
