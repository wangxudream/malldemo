package com.kataer.mall.portal.goods.service.impl;

import com.kataer.mall.mbg.model.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class TransactionalTwo {
    @Autowired
    private GoodsServiceImpl goodsService;


    public void normalSave(List<Goods> goods) {
        log.info("this_class:" + this.getClass());
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveGoods(Goods goods) {
        goodsService.save(goods);
    }

}
