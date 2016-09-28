package com.tools

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


/**
 * Created by zhiqiang.zhao on 2016/8/17.
 */
class EncryptUtil {
    static String encode(String str) {
        MessageDigest md = null;
        String dstr = null;
        try {
            md = MessageDigest.getInstance("SHA");
            md.update(str.getBytes());
            dstr = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return dstr;
    }
}
