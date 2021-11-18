/**
  * Copyright 2021 bejson.com 
  */
package com.xjjk.wms.model.dto.response;

import com.xjjk.wms.model.vo.ResponseParam;
import lombok.Data;

@Data
public class QueryDbOrderInfoRespDTO {
    private String result;
    private String reason;
    private String resultCode;
    private ResponseParam responseParam;
    private String uniquerRequestNumber;
}