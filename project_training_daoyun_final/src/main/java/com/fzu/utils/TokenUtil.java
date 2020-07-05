package com.fzu.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    /**
     * 加密的秘钥,相当于服务器私钥,一定保管好,不能泄露
     */
    private static final String secret = "secret";
    /**
     * 获取token的key,一般token存在请求头和相应头中
     */
    public static final String tokenHeader = "tokenHeader";
    /**
     * token的有效时间,不需要自己验证失效,当失效后,会自动抛出异常
     */
    private static final Long expTime = 30 * 60 * 60 * 1000L;

    /**
     * 创建一个token
     * @param id
     * @return
     */
    public static String getToken(Integer id, String name) {
        //也可以添加这些之外的其他信息------------------------|
        //这里额外添加一个信息,尝试获取
        String uuid = "这里是额外的信息,UUIDkey";
        Map<String, Object> map = new HashMap<>();
        map.put("uuidkey", uuid);
        //也可以添加这些之外的其他信息------------------------|

        JwtBuilder builder = Jwts.builder();
        String token = builder
                //设置加密的方式
                .signWith(SignatureAlgorithm.HS256, secret)
                //设置生成token的关键信息,可以将关键的信息加密
                .setId(uuid).setSubject(name)
                //设置token的签发时间和实效的时间
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expTime))

                //这个方法实际上是调用的构造方法,so在获取改内容时,就直接将Claims按照map处理
                .addClaims(map)
                //生成秘钥
                .compact();

        System.out.println("token=" + token);
        return token;
    }

    /**
     * 获取用户的姓名
     * @param token
     */
    public static String getUserName(String token){
        String name = getTokenBody(token).getSubject();
        System.out.println("name====" + name);
        return name;
    }

    /**
     * 获取用户的id
     * @param token
     */
    public static String getUserId(String token){
        String id = getTokenBody(token).getId();
        System.out.println("id====" + id);
        return id;
    }

    /**
     * 获取用户的uuidkey
     * @param token
     */
    public static String getUUIDKey(String token,String key){
        String UUIDkey = (String) getTokenBody(token).get(key);
        System.out.println("UUIDkey====" + UUIDkey);
        return UUIDkey;
    }

    /**
     * 查看并解析token
     * 这个方法会在token异常的时候自动抛出异常,不用自定异常,
     * 只需要在验证的时候进行捕获即可
     * @param token
     * @return
     */
    public static Claims getTokenBody(String token){
        //这里得到是token中的载荷部分,也是具体信息的所在
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();
        //对应的是上边的
        Object uuidkey = claims.get("uuidkey");
        System.out.println(uuidkey);
        return claims;
    }

    //测试是否可以取到信息
    public static void main(String[] args) {
        String token = getToken(1, "mmm");
        System.out.println(token);
        String uuidkey = getUUIDKey(token, "uuidkey");
        //配置进去的是 uuidkey='这里是额外的信息,UUIDkey'
        System.out.println(uuidkey);

    }
}

