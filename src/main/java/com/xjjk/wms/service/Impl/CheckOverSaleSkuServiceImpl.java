package com.xjjk.wms.service.Impl;

import com.xjjk.wms.dao.silkroad.GoodsStockShopMapper;
import com.xjjk.wms.service.CheckOverSaleSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOverSaleSkuServiceImpl implements CheckOverSaleSkuService {

    @Autowired
    private GoodsStockShopMapper goodsStockShopMapper;

    @Override
    public int getOverSaleSkuCount() {
        return goodsStockShopMapper.getOverSaleSkuBySQL();
    }
}
