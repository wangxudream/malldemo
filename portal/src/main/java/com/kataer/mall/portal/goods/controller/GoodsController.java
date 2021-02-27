package com.kataer.mall.portal.goods.controller;


import com.kataer.mall.mbg.model.Goods;
import com.kataer.mall.portal.goods.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kataer
 * @since 2021-01-17
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private GoodsServiceImpl goodsService;

    @GetMapping("/{id}")
    public Goods getById(@PathVariable("id") Long id) {
        return goodsService.getById(id);
    }

    @GetMapping("/serverId")
    public String hello() {
        System.out.println("server_port:"+port);
        return port;
    }
}

