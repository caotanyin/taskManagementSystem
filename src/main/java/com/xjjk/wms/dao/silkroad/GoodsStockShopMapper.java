package com.xjjk.wms.dao.silkroad;

import com.xjjk.wms.model.vo.GoodsStockShopVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsStockShopMapper {
    /**
     * 查询丝路SKU的可用总量
     *
     * @param skuCode
     * @return
     */
    @Select("select ifnull(sum(AvailableStock),0) num from goods_stock_shop where SkuCode = #{skuCode} and IsDeleted = 0 ;")
    int getSkuCodeAvailableQtyBySQL(String skuCode);

    @Select("select count(*) from goods_stock_shop where LockStock - AvailableStock - PreSaleStock > 0 and IsDeleted = 0;")
    int getOverSaleSkuBySQL();

    /**
     * 获取需要比对数量的SKU
     *
     * @return
     */
    @Select("select SkuCode " +
            "from goods_stock_shop " +
            "where SkuCode not like '%已作废%' " +
            "and AvailableStock > 0 " +
            "and SkuCode not like 'K%' " +
            "and SkuCode not like 'ART%' " +
            "and char_length(SkuCode) = 10 " +
            "GROUP BY SkuCode " +
            "ORDER BY UpdateTime desc " +
            "limit 30;")
    List<GoodsStockShopVO> getNeedCheckSku();
}
