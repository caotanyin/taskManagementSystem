package com.xjjk.wms;

import com.xjjk.wms.service.CarrierService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WmsApplicationTests {

    @Autowired
    private CarrierService carrierService;

    @Test
    void contextLoads() {
        int codValue = carrierService.queryDBOrderinfos("DEPPON","ISAG211115003954");
        log.info("代收货款：{}",codValue);
    }

}