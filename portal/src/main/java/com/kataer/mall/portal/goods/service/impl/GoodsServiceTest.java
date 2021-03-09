package com.kataer.mall.portal.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kataer.mall.mbg.mapper.GoodsMapper;
import com.kataer.mall.mbg.model.Goods;
import com.kataer.mall.portal.goods.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kataer
 * @since 2021-01-17
 */
@Slf4j
@Service
public class GoodsServiceTest extends ServiceImpl<GoodsMapper, Goods> {
    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveRequired(Goods goods) {
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("TX_ID:" + currentTransactionName);
        goodsMapper.insert(goods);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveNested(Goods goods) {
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("TX_ID:" + currentTransactionName);
//        System.out.println(1 / 0);
        goodsMapper.insert(goods);
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveTest() {
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("TX_ID:" + currentTransactionName);
        Goods goods1 = new Goods();
        goods1.setName("测试事务102L");
        goods1.setId(102L);
        Goods goods2 = new Goods();
        goods2.setName("测试事务103L");
        goods2.setId(103L);
        saveRequired(goods1);
        saveNested(goods2);
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {

        }
    }

}
