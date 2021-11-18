/**
  * Copyright 2021 bejson.com 
  */
package com.xjjk.wms.model.vo;

import lombok.Data;

@Data
public class ResponseParam {

    private String backSignBill;
    private int backSignBillPrice;
    private String businessNetworkNo;
    private String cargoName;
    private int codPrice;
    private int codValue;
    private int deliveryPrice;
    private int insurancePrice;
    private int insuranceValue;
    private String logisticCompanyID;
    private String logisticID;
    private String mailNo;
    private int otherPrice;
    private String packageService;
    private int packageServicePrice;
    private String payType;
    private QueryDBContactInfosVO receiver;
    private QueryDBContactInfosVO sender;
    private String statusType;
    private String toNetworkNo;
    private int totalNumber;
    private int totalPrice;
    private double totalVolume;
    private int totalWeight;
    private int transportPrice;
    private String transportType;
    private String vistReceive;
    private int vistReceivePrice;
    private String waitNotifySend;
}