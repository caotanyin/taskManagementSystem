package com.xjjk.wms.model.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class GetAvailableQtyReqDTO implements Serializable {
    private static final long serialVersionUID = -1L;
    //产品编码
    private String skuCode;
}
