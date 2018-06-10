package com.app.vn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> get(@RequestParam(required = false,defaultValue = "1") int pageNumber,
                                             @RequestParam(required = false,defaultValue = "50") int pageSize){
        return new ResponseEntity<String>("Rest API for website bloglaptrinh.herokuapp.com", HttpStatus.OK);
    }
}
