package com.dnk.smart.door.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURL().toString());

        HttpSession session = request.getSession();
        System.out.println("login : " + session.getAttribute("user") == null);

        if (session.getAttribute("user") != null) {
            return true;
        }

        //ajax
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            response.setHeader("timeout", "true");
        } else {
            response.sendRedirect(request.getContextPath() + "jsp/login.jsp");
        }
        return false;
    }
}
