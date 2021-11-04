package com.xjjk.wms.model.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class GetAvailableQtyRespDTO implements Serializable {
    private static final long serialVersionUID = -1L;
    private String sku;
    private String customerId;
    private String warehouseId;
    private int qty;
}
