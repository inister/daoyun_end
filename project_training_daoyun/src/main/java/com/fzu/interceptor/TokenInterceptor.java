package com.fzu.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.fzu.utils.JwtUtil;
import com.fzu.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TokenInterceptor implements HandlerInterceptor {
    /**
     * 预处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取token
        String token = request.getHeader(TokenUtil.tokenHeader);
        System.out.println("token===================="+token);
        if (null==token) {
            response.sendRedirect(request.getContextPath() + "/token/login");
            System.out.println("没有携带token");
            return false;
        }
        try {
            TokenUtil.getTokenBody(token);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("http://127.0.0.1:8080/login");
            System.out.println("token有问题");
            return false;
        }
        return true;
    }


    /**
     * 后处理
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 最后处理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie =  cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }
    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 返回信息给客户端
     *
     * @param response
     * @param out
     * @param apiResponse
     */
//    private void responseMessage(HttpServletRequest request, HttpServletResponse response, PrintWriter out, ApiResponse apiResponse) throws IOException {
//        response.setContentType("application/json; charset=utf-8");
//        out.print(JSONObject.toJSONString(apiResponse));
//        out.flush();
//        out.close();
//    }
}
