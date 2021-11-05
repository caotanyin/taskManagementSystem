package com.xjjk.wms.service.Impl;

import com.xjjk.wms.constant.SilkroadProperties;
import com.xjjk.wms.feign.AuthFeignClient;
import com.xjjk.wms.feign.OmsFeignClient;
import com.xjjk.wms.model.dto.Result;
import com.xjjk.wms.model.dto.request.GetAvailableQtyReqDTO;
import com.xjjk.wms.model.dto.request.GetTokenReqDTO;
import com.xjjk.wms.model.dto.response.GetAvailableQtyRespDTO;
import com.xjjk.wms.model.dto.response.GetTokenRespDTO;
import com.xjjk.wms.service.SilkroadService;
import com.xjjk.wms.util.ParamUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class SilkroadServiceImpl implements SilkroadService {

    private final SilkroadProperties silkroadProperties;

    private final AuthFeignClient authFeignClient;

    private final OmsFeignClient omsFeignClient;

    /**
     * 调用鉴权接口获取Token
     *
     * @return
     */
    @Override
    public String auth() {
        GetTokenReqDTO getTokenReqDTO = new GetTokenReqDTO();
        getTokenReqDTO.setAccessKeyID(silkroadProperties.getAccessKeyID());
        getTokenReqDTO.setAccessKeySecret(silkroadProperties.getAccessKeySecret());

        Result<GetTokenRespDTO> resp = authFeignClient.token(getTokenReqDTO);

        if (ParamUtil.objectEmpty(resp)) {
            log.info("丝路open-api鉴权失败");
            return null;
        }
        if (1000 != resp.getCode()) {
            log.info("丝路open-api鉴权失败:{}", resp.getMsg());
            return null;
        }
        if (ParamUtil.objectEmpty(resp.getData()) || ParamUtil.strEmpty(resp.getData().getToken())) {
            log.info("丝路open-api鉴权失败无数据");
            return null;
        }
        return resp.getData().getToken();
    }

    /**
     * 根据SkuCode及传入的Token试试查询当前丝路库存
     *
     * @param token
     * @param skuCode
     * @return
     */
    @Override
    public int queryAvailableQtyByInterface(String token, String skuCode) {
        GetAvailableQtyReqDTO getAvailableQtyReqDTO = new GetAvailableQtyReqDTO();
        getAvailableQtyReqDTO.setSkuCode(skuCode);
        Result<GetAvailableQtyRespDTO> resp = omsFeignClient.availableStock(token, getAvailableQtyReqDTO);
        if (ParamUtil.objectEmpty(resp)) {
            log.info("丝路调用查询库存查询接口失败");
            return 0;
        }
        if (1000 != resp.getCode()) {
            log.info("丝路调用查询库存查询接口失败:{}", resp.getMsg());
            return 0;
        }
        if (ParamUtil.objectEmpty(resp.getData())) {
            log.info("丝路调用查询库存查询接口失败无数据:{}", skuCode);
            return 0;
        }
        return resp.getData().getQty();
    }

}
