package com.fzu.exception.resolver;

import com.fzu.exception.AuthorityInadequateException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        if (e instanceof AuthorityInadequateException) {
            try {
                httpServletResponse.getWriter().write("no_this_authority");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
