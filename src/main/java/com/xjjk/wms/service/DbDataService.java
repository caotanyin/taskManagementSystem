package com.xjjk.wms.service;

import com.xjjk.wms.model.vo.GoodsStockShopVO;

import java.util.List;

public interface DbDataService {

    int queryAvailableQtyBySql(String sku);

    int queryOverSaleBySQL();

    List<GoodsStockShopVO> getSku();
}
