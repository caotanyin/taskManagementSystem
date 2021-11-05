package com.xjjk.wms.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class GetTokenReqDTO implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 第三方平台公钥
     */
    private String AccessKeyID;
    /**
     * 第三方平台秘钥
     */
    private String AccessKeySecret;
}
