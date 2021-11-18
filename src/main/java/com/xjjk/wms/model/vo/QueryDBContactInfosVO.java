package com.xjjk.wms.model.vo;

import lombok.Data;

@Data
public class QueryDBContactInfosVO {
    /**
     * 发货/收货人公司
     */
    private String companyName;
    /**
     * 发货/收货人名称
     */
    private String name;
    /**
     * 发货/收货人邮编
     */
    private String postCode;
    /**
     * 发货/收货人电话
     */
    private String phone;
    /**
     * 发货/收货人手机
     */
    private String mobile;
    /**
     * 发货/收货人省份
     */
    private String province;
    /**
     * 发货/收货人城市
     */
    private String city;
    /**
     * 发货/收货人区县
     */
    private String country;
    /**
     * 发货/收货人详细地址
     */
    private String address;
    //街道
    private String street;
}
