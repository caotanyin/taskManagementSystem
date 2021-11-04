package com.xjjk.wms.feign;

import com.xjjk.wms.model.dto.Result;
import com.xjjk.wms.model.dto.request.GetAvailableQtyReqDTO;
import com.xjjk.wms.model.dto.response.GetAvailableQtyRespDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(url = "${microservices.wms.base}", name = "OmsFeignClient")
@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface OmsFeignClient {
    @PostMapping(value = "/product/inventory", produces = "application/json")
    Result<GetAvailableQtyRespDTO> availableStock(@RequestHeader(name = "Authorization") String token,
                                                  @RequestBody GetAvailableQtyReqDTO getAvailableQtyReqDTO);
}
