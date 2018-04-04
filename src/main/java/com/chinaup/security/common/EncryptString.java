package com.chinaup.security.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptString {

    private static Logger logger = LoggerFactory.getLogger(EncryptString.class);

    public static String applySHA256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for(byte ha :hash){
                String hex = Integer.toHexString(0xff & ha);
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            logger.error("加密错误",e);
            return null;
        }

    }
}
