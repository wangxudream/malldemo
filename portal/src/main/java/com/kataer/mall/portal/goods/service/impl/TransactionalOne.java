package com.kataer.mall.portal.goods.service.impl;

import com.kataer.mall.mbg.model.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class TransactionalOne {
    @Autowired
    private GoodsServiceTest goodsServiceTest;

    public void normalSave(List<Goods> goods) {
        log.info("this_class:" + this.getClass());
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveGoods() {
        Goods goods1 = new Goods();
        goods1.setName("测试事务100L");
        goods1.setId(100L);
        Goods goods2 = new Goods();
        goods2.setName("测试事务101L");
        goods2.setId(101L);
        goodsServiceTest.saveRequired(goods1);
        try {
            goodsServiceTest.saveNested(goods2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save() {
        goodsServiceTest.saveTest();
    }
}
