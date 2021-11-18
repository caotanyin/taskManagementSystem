package com.xjjk.wms.service;

import com.xjjk.wms.model.vo.SkuDifferentInventoryQtyVO;

import java.util.List;

public interface CheckDiffInventoryQtyService {
    /**
     * 核对库存差异
     * @return 差异集合
     */
    List<SkuDifferentInventoryQtyVO> checkDiff();
}
