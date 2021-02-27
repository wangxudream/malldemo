package com.kataer.mall.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pay")
public class PayController {
    @PostMapping("/notify")
    public String parseOrderNotifyResult(@RequestBody String xmlData) {
        System.out.println(xmlData);
        return "SUCCESS";
    }
}
