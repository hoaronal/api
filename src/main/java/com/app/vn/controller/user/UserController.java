package com.app.vn.controller.user;

import com.app.vn.common.model.User;
import com.app.vn.common.utils.PasswordUtil;
import com.app.vn.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("private")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("infoUser")
    public String getInfoUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return "";
    }

    @GetMapping("add")
    public ResponseEntity<User> add(){
        User user = new User();
        /*user.setEmail("hoa9x3@gmail.com");
        user.setLoginPassword(PasswordUtil.genarate("anhpro1993"));
        user.setLoginId("hoaronal");
        user.setFirstName("Quang");
        user.setLastName("Hòa");
        userService.add(user);*/
        user = userService.getByLoginId("hoaronal");

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
       // return new CoreResponse(true, user);
    }
}
