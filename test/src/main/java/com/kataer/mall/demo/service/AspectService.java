package com.kataer.mall.demo.service;

import com.kataer.mall.demo.aspect.ParamCheck;
import org.springframework.stereotype.Service;

@Service
public class AspectService {

    @ParamCheck
    public void testParamCheck(String arg) {
        if ("".equals(arg)) {
            throw new RuntimeException();
        }
        System.out.println("校验参数成功");
    }
}
