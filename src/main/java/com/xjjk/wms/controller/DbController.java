package com.xjjk.wms.controller;

import com.xjjk.wms.model.dto.request.QueryDBOrderinfosReqDTO;
import com.xjjk.wms.service.CarrierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrier/query")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class DbController {
    private CarrierService carrierService;
    @PostMapping("/dbCodValue")
    int queryDbCodValue(@RequestBody QueryDBOrderinfosReqDTO queryDBOrderinfosReqDTO){
        log.info("查询德邦代收货款参数：{}",queryDBOrderinfosReqDTO);
        if( queryDBOrderinfosReqDTO == null ){
            return  0;
        }
        return carrierService.queryDBOrderinfos(queryDBOrderinfosReqDTO.getLogisticCompanyID(),queryDBOrderinfosReqDTO.getLogisticID());
    }
}
