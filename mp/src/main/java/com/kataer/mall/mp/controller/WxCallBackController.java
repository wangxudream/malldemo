package com.kataer.mall.mp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class WxCallBackController {

    @GetMapping("/test")
    public String checkServer(){
        return "Helllo";
    }
}
