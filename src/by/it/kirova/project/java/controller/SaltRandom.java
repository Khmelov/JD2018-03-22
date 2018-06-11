package by.it.kirova.project.java.controller;

//import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

public class SaltRandom {
    public static void main(String[] args) {
//        String salt = "randomstring";
//        String abc = "abc123"; //user abc@gmail.com
//        String def = "def123"; //user def@gmail.com
//        String hij = "hij123"; //user hij@gmail.com
//        String klm = "klm123"; //user klm@gmail.com
//        String rst = "rst123"; //user rst@gmail.com
//        String nop = "nop123"; //user nop@gmail.com
//
//        String hashpassabc = DigestUtils.sha256Hex(abc + salt);
//        String hashpassdef = DigestUtils.sha256Hex(def + salt);
//        String hashpasshij = DigestUtils.sha256Hex(hij+ salt);
//        String hashpassklm = DigestUtils.sha256Hex(klm + salt);
//        String hashpassrst = DigestUtils.sha256Hex(rst + salt);
//        String hashpassnop = DigestUtils.sha256Hex(nop + salt);
//        System.out.println(hashpassabc);
//        System.out.println(hashpassdef);
//        System.out.println(hashpasshij);
//        System.out.println(hashpassklm);
//        System.out.println(hashpassrst);
//        System.out.println(hashpassnop);

    }

    public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
