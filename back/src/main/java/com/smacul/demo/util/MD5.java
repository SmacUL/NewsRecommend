package com.smacul.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String MD5Creator(String plainString) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte b[] = md5.digest(plainString.getBytes());
        int i;
        StringBuffer buf = new StringBuffer("");
        for(int offset = 0; offset < b.length; offset ++){
            i = b[offset];
            if(i < 0){
                i += 256;
            }
            if(i < 16){
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }

        return buf.toString();
    }

}
