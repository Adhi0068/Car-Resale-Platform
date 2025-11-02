package com.app.service;


import com.app.payload.OTPDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class OTPService {

    private final Map<String, OTPDetails> otpStorage = new HashMap<>();
    private static final int OTP_EXPIRY_TIME= 5;

    public String generateOTP (String mobileNumber){

        //Generating a random 6-digit otp
        String otp = String.format("%06d", new Random().nextInt(999999));

        //Storing OTP and its  creation time in the Hashmap
        OTPDetails otpDetails = new OTPDetails(otp, System.currentTimeMillis());

        //storing it on a Hashmap
        // key --> mobileNumber , and value -->otpDetails(otp, time when otp was generated)
        otpStorage.put(mobileNumber, otpDetails);

        return otp;
    }

    public boolean validateOTP(String mobileNumber, String otp){
        OTPDetails otpDetails = otpStorage.get(mobileNumber);// fetching otp details against mobileNumber

        if(otpDetails == null){
            return  false; //No details present means OTP not generated
        }

        //check if OTP is expired:
        long currentTime = System.currentTimeMillis();
        long otpCreationTime = otpDetails.getTimeStamp(); //fetching this detail from otpDetails i.e. on Hashmap
        long timeDifference = TimeUnit.MILLISECONDS.toMinutes(currentTime - otpCreationTime);

        if(timeDifference > OTP_EXPIRY_TIME ){
            otpStorage.remove(mobileNumber);//Remove expired OTP
            return false; //OTP is expired
        }

        //Validate OTP: compare the entered OTP with the stored one
        return otpDetails.getOtp().equals(otp);
    }

}



