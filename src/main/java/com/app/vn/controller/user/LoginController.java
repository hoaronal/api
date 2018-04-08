package com.app.vn.controller.user;


import com.app.vn.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;
    @GetMapping("login")
    public String getArticleById(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("app_username");
        String password = request.getParameter("app_password");
        return "";
    }

    @GetMapping("logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
