package com.xjjk.wms.util;

import com.xjjk.wms.model.vo.SkuDifferentInventoryQtyVO;
import com.xjjk.wms.service.CheckDiffInventoryQtyService;
import com.xjjk.wms.service.CheckOverSaleSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class TaskUtil {

    @Autowired
    private CheckDiffInventoryQtyService checkDiffInventoryQtyService;

    @Autowired
    private CheckOverSaleSkuService checkOverSaleSkuService;

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(cron = "0 0/15 8-17 * * ?")
    public void doCheckDifferentInventory() {
        log.info("核对库存任务启动...");

        List<SkuDifferentInventoryQtyVO> skuDifferentInventoryQtyVOS = checkDiffInventoryQtyService.checkDiff();

        log.info("本次产品库存核对，存在问题的产品数量为：{}", skuDifferentInventoryQtyVOS.size());

        if (skuDifferentInventoryQtyVOS != null && skuDifferentInventoryQtyVOS.size() > 20) {
            String skuStr = "";
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("cao1423941511@163.com");
            message.setTo("1423941511@qq.com");
            message.setSubject("主题：库存差异");
            for (int i = 0; i < skuDifferentInventoryQtyVOS.size(); i++) {
                skuStr = skuStr + "sku:" + skuDifferentInventoryQtyVOS.get(i).getSku() + "丝路库存："
                        + skuDifferentInventoryQtyVOS.get(i).getSrInventory() + "WMS系统库存："
                        + skuDifferentInventoryQtyVOS.get(i).getWmsInventory()
                        + '\n';
            }
            message.setText("库存存在差异情况！请及时检查WMS-CANAL运行情况！\n" + skuStr);
            mailSender.send(message);
        }
        log.info("核对库存任务结束...");
    }

    @Scheduled(cron = "0 0/3 8-17 * * ?")
    public void doCheckOverSaleSku() {
        log.info("核对超售产品数量任务启动...");
        int num = checkOverSaleSkuService.getOverSaleSkuCount();
        if (num > 0) {
            log.info("本次产品库存核对，存在问题的产品数量为：{}", num);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("cao1423941511@163.com");
            message.setTo("1423941511@qq.com");
            message.setSubject("主题：库存超售情况");
            message.setText("当前存在" + num + "个产品存在超售情况，请及时处理");
            mailSender.send(message);
        }
        log.info("核对超售产品数量任务结束...");
    }
}
