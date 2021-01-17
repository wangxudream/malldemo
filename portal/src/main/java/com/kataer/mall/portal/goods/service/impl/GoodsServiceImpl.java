package com.kataer.mall.portal.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kataer.mall.model.*;
import com.kataer.mall.mapper.GoodsMapper;
import com.kataer.mall.portal.goods.service.IGoodsService;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kataer
 * @since 2021-01-17
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void selectForward(ResultHandler<Goods> handler) {
        goodsMapper.selectForward(handler);
    }
}
