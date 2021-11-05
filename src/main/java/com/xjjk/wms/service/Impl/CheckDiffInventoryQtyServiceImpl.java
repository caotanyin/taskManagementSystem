package com.xjjk.wms.service.Impl;

import com.xjjk.wms.model.vo.GoodsStockShopVO;
import com.xjjk.wms.model.vo.SkuDifferentInventoryQtyVO;
import com.xjjk.wms.service.DbDataService;
import com.xjjk.wms.service.SilkroadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CheckDiffInventoryQtyServiceImpl implements com.xjjk.wms.service.CheckDiffInventoryQtyService {

    private final SilkroadService silkroadService;

    private final DbDataService dbDataService;

    @Override
    public List<SkuDifferentInventoryQtyVO> checkDiff() {
        String token = silkroadService.auth();
        List<GoodsStockShopVO> list = dbDataService.getSku();
        List<SkuDifferentInventoryQtyVO> skuDifferentInventoryQtyVOList = new ArrayList<>();
        for (GoodsStockShopVO goodsStockShopVO : list) {
            int wmsInventery = silkroadService.queryAvailableQtyByInterface(token, goodsStockShopVO.getSkuCode());
            int srInventory = dbDataService.queryAvailableQtyBySql(goodsStockShopVO.getSkuCode());
            if (wmsInventery != srInventory) {
                SkuDifferentInventoryQtyVO skuDifferentInventoryQtyVO = new SkuDifferentInventoryQtyVO();
                skuDifferentInventoryQtyVO.setSku(goodsStockShopVO.getSkuCode());
                skuDifferentInventoryQtyVO.setWmsInventory(wmsInventery);
                skuDifferentInventoryQtyVO.setSrInventory(srInventory);
                skuDifferentInventoryQtyVOList.add(skuDifferentInventoryQtyVO);
            }
        }
        return skuDifferentInventoryQtyVOList;
    }


}
