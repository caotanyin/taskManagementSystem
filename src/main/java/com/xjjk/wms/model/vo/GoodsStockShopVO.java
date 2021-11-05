package com.xjjk.wms.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsStockShopVO {
    private Integer id;
    private Integer shopId;
    private String skuCode;
    private Integer availableStock;
    private Integer lockStock;
    private Integer preSaleStock;
    private String createSource;
    private Date createTime;
    private String updateSource;
    private Date updateTime;
    private Integer isDeleted;
}
