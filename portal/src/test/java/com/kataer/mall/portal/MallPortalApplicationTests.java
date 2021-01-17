package com.kataer.mall.portal;

import com.kataer.mall.mapper.GoodsMapper;
import com.kataer.mall.model.Goods;
import com.kataer.mall.portal.goods.controller.GoodsResultHandler;
import com.kataer.mall.portal.goods.service.IGoodsService;
import com.kataer.mall.portal.goods.service.impl.GoodsServiceImpl;
import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallPortalApplicationTests {
    private ExecutorService pool = Executors.newSingleThreadExecutor();
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsServiceImpl goodsService;

    @Test
    public void contextLoads() {
        List<Goods> goodsList = new ArrayList<>(1000);
        for (int i = 0; i < 100000; i++) {
            Goods goods = new Goods();
            goods.setName("测试" + i);
            goodsList.add(goods);
            if (goodsList.size() == 1000) {
                goodsService.saveBatch(goodsList, 1000);
                goodsList.clear();
            }
        }
        goodsService.saveBatch(goodsList, goodsList.size());
    }


    @Test
    public void Insert() {
    }

    @Test
    public void testForward() throws InterruptedException {
        int totalSize = goodsService.count();
        SXSSFWorkbook wb = new SXSSFWorkbook(1000);
        Sheet sh = wb.createSheet(); // 建立新的sheet对象
        Row row = sh.createRow(0);   // 创建第一行对象
        // -----------定义表头-----------
        Cell cel0 = row.createCell(0);
        cel0.setCellValue("1");
        Cell cel2 = row.createCell(1);
        cel2.setCellValue("2");
        Cell cel3 = row.createCell(2);
        cel3.setCellValue("3");
        Cell cel4 = row.createCell(3);
        final CountDownLatch latch = new CountDownLatch(1);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务");
                long start = System.currentTimeMillis();
                goodsMapper.selectForward(new GoodsResultHandler(totalSize, wb, sh, "D:\\test.xlsx"));
                long end = System.currentTimeMillis();
                System.out.println("消耗时间ms:" + (end - start));
                latch.countDown();
            }
        });
        latch.await();
    }


}
