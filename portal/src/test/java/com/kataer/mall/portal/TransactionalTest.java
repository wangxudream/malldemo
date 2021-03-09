package com.kataer.mall.portal;

import com.kataer.mall.mbg.model.Goods;
import com.kataer.mall.portal.goods.service.impl.GoodsServiceTest;
import com.kataer.mall.portal.goods.service.impl.TransactionalOne;
import com.kataer.mall.portal.goods.service.impl.GoodsServiceImpl;
import com.kataer.mall.portal.goods.service.impl.TransactionalTwo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = "dev")
public class TransactionalTest {
    @Autowired
    private TransactionalOne transactionalOne;

    @Autowired
    private GoodsServiceTest goodsServiceTest;

    @Test
    public void test() {
        transactionalOne.saveGoods();
    }

    @Test
    public void testNormal() {
        goodsServiceTest.saveTest();
    }

}
