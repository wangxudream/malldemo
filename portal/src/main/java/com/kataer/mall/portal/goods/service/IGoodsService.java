package com.kataer.mall.portal.goods.service;

import com.kataer.mall.mbg.model.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.session.ResultHandler;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author kataer
 * @since 2021-01-17
 */
public interface IGoodsService extends IService<Goods> {
    void selectForward(ResultHandler<Goods> handler);

    void testDoOrder(Long id, CountDownLatch latch);
}
