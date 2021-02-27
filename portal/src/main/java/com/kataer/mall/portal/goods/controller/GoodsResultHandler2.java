package com.kataer.mall.portal.goods.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.kataer.mall.mbg.model.Goods;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GoodsResultHandler2
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/18 23:00
 * @Version V1.0
 **/
public class GoodsResultHandler2 implements ResultHandler<Goods> {
    private String path = "D:\\test.xlsx";
    private List<Goods> goodsList = new ArrayList<>(1000);
    private int size = 5;
    private int totalCount;

    @Override
    public void handleResult(ResultContext<? extends Goods> resultContext) {
        Goods goods = resultContext.getResultObject();
        if (goodsList.size() < 1000) {
            goodsList.add(goods);
        } else {

        }
    }

    private int pageSize(int totalCount, int page) {
        return totalCount / page;
    }

    private ExcelWriter createExcelWriter() {
        return EasyExcel.write(path, Goods.class).build();
    }

    private WriteSheet creatSheet(int index, String sheetName) {
        return EasyExcel.writerSheet(index, sheetName).build();
    }
}
