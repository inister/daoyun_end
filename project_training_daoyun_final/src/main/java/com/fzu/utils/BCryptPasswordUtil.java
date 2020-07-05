package com.fzu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordUtil {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static boolean decodePassword(String rawPassword, String encodePassword) {
        boolean matches = bCryptPasswordEncoder.matches(rawPassword, encodePassword);
        return matches;
    }

    public static void main(String[] args) {
//        System.out.println(encodePassword("123456"));
        System.out.println(decodePassword("123456", "$2a$10$iCKWy/vyXDRg8OdU9PxMbeYMk6UQxf0W2FAl14ByDaSfDUTotcZFK"));
//        String ruleEmail = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
//        String str1 = "123456";
//        String str2 = "1235@qq.com";
//        String str3 = "1s235e@163.com";
//        String str4 = "1235@gmail.com";
//        System.out.println(str1.matches(ruleEmail));
//        System.out.println(str2.matches(ruleEmail));
//        System.out.println(str3.matches(ruleEmail));
//        System.out.println(str4.matches(ruleEmail));
    }
}
