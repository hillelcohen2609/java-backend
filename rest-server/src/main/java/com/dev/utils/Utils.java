package com.dev.utils;

import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.dev.utils.Constants.MINIMUM_LENGTH_PASSWORD;

@Component
public class Utils {


    public String createHash (String username, String password) {
        String raw = String.format("%s_%s", username, password);
        String myHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(raw.getBytes());
            byte[] digest = md.digest();
            myHash = DatatypeConverter
                    .printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return myHash;
    }
    public boolean isStrongPassword(String password){
        boolean isStrong = false;
        if (password.length() >= MINIMUM_LENGTH_PASSWORD){
            isStrong = true;
        }
        return isStrong;
    }
}
