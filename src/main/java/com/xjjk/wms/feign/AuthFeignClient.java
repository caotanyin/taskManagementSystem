package com.xjjk.wms.feign;

import com.xjjk.wms.model.dto.Result;
import com.xjjk.wms.model.dto.request.GetTokenReqDTO;
import com.xjjk.wms.model.dto.response.GetTokenRespDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(url = "${microservices.auth.base}", name = "AuthFeignClient")
//加上configuration = FeignConfiguration.class配置yml文件即可调整类的日志打印级别，方便分析错误原因
//@FeignClient(url = "${microservices.auth.base}", name = "AuthFeignClient",configuration = FeignConfiguration.class)
@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface AuthFeignClient {
    @PostMapping(value = "/token", produces = "application/json")
    Result<GetTokenRespDTO> token(@RequestBody GetTokenReqDTO getTokenReqDTO);
}