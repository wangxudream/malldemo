package com.kataer.mall.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author kataer
 * @version 1.0
 * @description: Mybatis-plus元对象处理器
 * @date 2021/3/5 13:34
 */
public class MpMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //createdTime没有填充才填充数据
        if (metaObject.hasSetter("createdTime") && getFieldValByName("createdTime", metaObject) == null) {
            this.strictInsertFill(metaObject, "createdTime", Date.class, new Date());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //updatedTime没有填充才填充数据
        if (metaObject.hasSetter("updatedTime") && getFieldValByName("updatedTime", metaObject) == null) {
            this.strictUpdateFill(metaObject, "updatedTime", Date.class, new Date());
        }
    }
}
