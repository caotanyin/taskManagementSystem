package com.xjjk.wms.feign;

import com.deppon.dop.module.sdk.shared.domain.result.ResultDO;
import feign.Headers;
import org.apache.commons.httpclient.NameValuePair;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(url = "${carrierservices.db.base}", name = "DBFeignClient")
@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface DBFeignClient {
    @PostMapping(value = "/queryOrder.action", produces = "application/json")
    ResultDO<String> queryOrder(@RequestBody NameValuePair[] data);
}
