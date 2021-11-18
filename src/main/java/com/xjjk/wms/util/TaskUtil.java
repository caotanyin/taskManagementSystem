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

    @Scheduled(cron = "0 0/3 8-22 * * ?")
    public void doCheckWmsFtpServerOnLine() {
        log.info("检查服务器在线是否任务开始...");
        String hostname = "172.19.10.249";
        int port = 21 ;
        boolean onLineFlag = NetUtil.isOnline(hostname,port);
        if(!onLineFlag){
            String skuStr = "";
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("cao1423941511@163.com");
            message.setTo("1423941511@qq.com");
            message.setSubject("主题：服务器掉线");
            message.setText(hostname+"服务器已掉线！！！\n" + skuStr);
            mailSender.send(message);
        }else{
            log.info("{}服务器在线...",hostname);
        }
        log.info("检查服务器在线是否任务结束...");
    }
}
