package com.xjjk.wms.constant;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description: 丝路配置
 * Created by ruanyangyang on 2020/11/23 10:51
 */
@Data
@SpringBootConfiguration
@ConfigurationProperties(prefix = "silkroadapiaccesskey")
public class SilkroadProperties {

    /**
     * open-api 公钥
     */
    private String AccessKeyID;
    /**
     * open-api 私钥
     */
    private String AccessKeySecret;

}
