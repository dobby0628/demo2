package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping("/all")
    public void exAll(){ //모든 사용자가 접속 가능
        System.out.println("exAll..............................");
    }

    @RequestMapping("/member")
    public void exMember(){ //회원만 접속 가능
        System.out.println("exMember..............................");
    }

    @RequestMapping("/admin")
    public void exAdmin(){ // 관리자권한을 가진 회원만 접속 가능
        System.out.println("exAdmin..............................");
    }

}
