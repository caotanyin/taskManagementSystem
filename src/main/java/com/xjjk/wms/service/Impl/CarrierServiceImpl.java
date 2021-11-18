package com.xjjk.wms.service.Impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dop.module.sdk.shared.domain.result.ResultDO;
import com.deppon.dop.module.sdk.shared.util.HttpUtils;
import com.deppon.dop.module.sdk.shared.util.SecurityUtil;
import com.xjjk.wms.model.dto.response.QueryDbOrderInfoRespDTO;
import com.xjjk.wms.service.CarrierService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.NameValuePair;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CarrierServiceImpl implements CarrierService {

    @Override
    public int queryDBOrderinfos(String logisticCompanyID, String logisticID) {
        return CarrierServiceImpl.queryDBOrderinfosByHttpUtils(logisticCompanyID,logisticID);
    }

    private static int queryDBOrderinfosByHttpUtils(String logisticCompanyID, String logisticID) {
        Map<String, String> req = new HashMap<>();
        req.put("logisticCompanyID", logisticCompanyID);
        req.put("logisticID", logisticID);
        String params = JSONUtils.toJSONString(req);
        //companyCode与appkey为双方约定
        String companyCode = "EWBNJYPMDZSWYXGS";
        String appkey = "9ce45d97d0ace06b5aa986e75b0efab8";
        //时间戳 SDK提供SecurityUtil获取时间戳
        String timestamp = String.valueOf(System.currentTimeMillis());
        //摘要 SDK提供SecurityUtil生成摘要
        String digest = SecurityUtil.getCommonDigest(params + appkey + timestamp, "UTF-8");
        //post请求参数
        NameValuePair[] data = new NameValuePair[4];
        data[0] = new NameValuePair("companyCode", companyCode);
        data[1] = new NameValuePair("digest", digest);
        data[2] = new NameValuePair("timestamp", timestamp);
        data[3] = new NameValuePair("params", params);
        //请求url
        String url = "http://dpapi.deppon.com/dop-interface-sync/standard-query/queryOrder.action";
        ResultDO<String> response = null;
        //返回结果
        response = HttpUtils.sendRequest(url, data, "UTF-8", 5000);

        if(response.getModel() == null){
            log.info("德邦接口response.getModel为空！！！");
            return 0;
        }
        QueryDbOrderInfoRespDTO queryDbOrderInfoRespDTO = JSONObject.parseObject(response.getModel(), QueryDbOrderInfoRespDTO.class);
        if("订单不存在".equals(queryDbOrderInfoRespDTO.getReason())){
            log.info("德邦接口响应：{}",queryDbOrderInfoRespDTO.getReason());
            return 0;
        }
        log.info("渠道单号:{}  德邦代收货款:{}",logisticID,queryDbOrderInfoRespDTO.getResponseParam().getCodValue());
        return queryDbOrderInfoRespDTO.getResponseParam().getCodValue();

    }
}
