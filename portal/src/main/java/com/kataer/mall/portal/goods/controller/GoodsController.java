package com.kataer.mall.portal.goods.controller;


import com.kataer.mall.common.model.UserVo;
import com.kataer.mall.common.model.UserVoThreadLocal;
import com.kataer.mall.mbg.model.Goods;
import com.kataer.mall.portal.goods.service.impl.GoodsServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private GoodsServiceImpl goodsService;

    @GetMapping("/{id}")
    public Goods getById(@PathVariable("id") Long id) {
        UserVo userVo = UserVoThreadLocal.get();
        log.info(userVo.toString());
        return goodsService.getById(id);
    }

    @GetMapping("/serverId")
    public String hello() {
        System.out.println("server_port:" + port);
        return port;
    }
}

