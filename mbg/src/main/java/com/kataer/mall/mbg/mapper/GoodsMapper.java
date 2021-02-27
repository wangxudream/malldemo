package com.kataer.mall.mbg.mapper;

import com.kataer.mall.mbg.model.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.ResultHandler;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author kataer
 * @since 2021-01-17
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("select * from goods")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 100)
    @ResultType(Goods.class)
    void selectForward(ResultHandler<Goods> handler);
}
