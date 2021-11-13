package com.xjjk.wms.service;

public interface SilkroadService {
    /**
     * 获取丝路鉴权TOKEN
     * @return
     */
    String auth();

    /**
     * 通过接口方式获取sku可用数量
     * @param token 丝路鉴权TOKEN
     * @param skuCode 产品编码
     * @return
     */
    int queryAvailableQtyByInterface(String token, String skuCode);
}
