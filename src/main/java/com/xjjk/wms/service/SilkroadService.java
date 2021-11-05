package com.xjjk.wms.service;

import com.xjjk.wms.model.vo.GoodsStockShopVO;

import java.util.List;

public interface SilkroadService {
    //鉴权获取Token
    String auth();

    //接口获取SKU的数量
    int queryAvailableQtyByInterface(String token, String skuCode);
}
