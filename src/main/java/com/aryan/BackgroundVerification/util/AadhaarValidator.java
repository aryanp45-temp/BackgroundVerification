package com.aryan.BackgroundVerification.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AadhaarValidator {

    public static boolean isValidAadhaarNumber(String str) {
        String regex = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";

        Pattern p = Pattern.compile(regex);

        if (str == null) {
            return false;
        }

        Matcher m = p.matcher(str);

        return m.matches();
    }

}
