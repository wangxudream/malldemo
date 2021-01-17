package com.kataer.mall.portal.goods.controller;

import com.kataer.mall.model.Goods;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName MyResultHandler
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/17 18:47
 * @Version V1.0
 **/
public class GoodsResultHandler implements Runnable, ResultHandler<Goods> {
    private final int size;
    private final SXSSFWorkbook wb;
    private final Sheet sh;
    private final String path;

    public GoodsResultHandler(int size, SXSSFWorkbook wb, Sheet sh, String path) {
        this.size = size;
        this.wb = wb;
        this.sh = sh;
        this.path = path;
    }

    @Override
    public void handleResult(ResultContext<? extends Goods> resultContext) {
        if (resultContext.getResultCount() < size) {
            Goods goods = resultContext.getResultObject();
            Row row_value = sh.createRow(resultContext.getResultCount());
            Cell id = row_value.createCell(0);
            id.setCellValue(goods.getId());
            Cell name = row_value.createCell(1);
            name.setCellValue(goods.getName());
            Cell price = row_value.createCell(2);
            price.setCellValue(goods.getPrice());
        } else {
            System.out.println("抽取数据结束");
            Goods goods = resultContext.getResultObject();
            Row row_value = sh.createRow(resultContext.getResultCount());
            Cell id = row_value.createCell(0);
            id.setCellValue(goods.getId());
            Cell name = row_value.createCell(1);
            name.setCellValue(goods.getName());
            Cell price = row_value.createCell(2);
            price.setCellValue(goods.getPrice());
            try {
                FileOutputStream fileOut = new FileOutputStream(path);
                wb.write(fileOut);
                fileOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                wb.dispose();
            }
        }
    }

    @Override
    public void run() {

    }
}
