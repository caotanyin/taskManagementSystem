package com.xjjk.wms.model.vo;

import lombok.Data;

@Data
public class SkuDifferentInventoryQtyVO {
    private String sku;
    private Integer wmsInventory;
    private Integer srInventory;
}
