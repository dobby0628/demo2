package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public void login(){

    }

    @GetMapping("/signup")
    public void signup(){

    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserDTO userDTO){
        userService.signup(userDTO);

        return "redirect:login";
    }
}
