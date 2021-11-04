package com.xjjk.wms.service.Impl;

import com.xjjk.wms.dao.silkroad.GoodsStockShopMapper;
import com.xjjk.wms.model.vo.GoodsStockShopVO;
import com.xjjk.wms.service.DbDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbDataServiceImpl implements DbDataService {
    @Autowired
    private GoodsStockShopMapper goodsStockShopMapper;

    @Override
    public int queryAvailableQtyBySql(String sku) {
        return goodsStockShopMapper.getSkuCodeAvailableQtyBySQL(sku);
    }

    @Override
    public int queryOverSaleBySQL() { return goodsStockShopMapper.getOverSaleSkuBySQL(); }

    @Override
    public List<GoodsStockShopVO> getSku() {
        return goodsStockShopMapper.getNeedCheckSku();
    }
}
