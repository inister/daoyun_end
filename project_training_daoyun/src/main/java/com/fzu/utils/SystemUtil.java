package com.fzu.utils;

import java.security.MessageDigest;

/**
 * Created by 13 on 17/7/10.
 */
public class SystemUtil {

    private SystemUtil(){}


    /**
     * 登录或注册成功后,生成保持用户登录状态会话token值
     * @param src:为用户最新一次登录时的now()+user.id+random(4)
     * @return
     */
    public static String genToken(String src){
        if (null == src || "".equals(src)){
            return null;
        }
        try {
           /* // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(src.getBytes());
            //digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);*/
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            byte[] hash = md.digest();
            StringBuilder secpwd = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                if (v < 16) {
                    secpwd.append(0);
                }
                secpwd.append(Integer.toString(v, 16));
            }
            return secpwd.toString();
        } catch (Exception e) {
            return null;
        }
    }

}
