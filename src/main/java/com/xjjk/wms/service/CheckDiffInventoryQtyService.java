package com.xjjk.wms.service;

import com.xjjk.wms.model.vo.SkuDifferentInventoryQtyVO;

import java.util.List;

public interface CheckDiffInventoryQtyService {
    List<SkuDifferentInventoryQtyVO> checkDiff();
}
