package com.dnk.smart.door.controller;

import com.dnk.smart.door.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController extends CommonsController {

    @RequestMapping(value = "/login")
    @ResponseBody
    public boolean login(String name, String password) {
        System.out.println(request);
        User user = userService.login(name, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }
}
