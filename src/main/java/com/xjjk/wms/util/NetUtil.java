package com.xjjk.wms.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Slf4j
public class NetUtil {
    /**
     * 通过telnet的方式检查指定地址的连通性是否正常
     * @param hostname 指定地址
     * @param port 端口号
     * @return true:连通性正常;false:连通性异常
     */
    public static boolean isOnline(String hostname, int port) {
        Socket server = null;
        try {
            server = new Socket();
            InetSocketAddress address = new InetSocketAddress(hostname, port);//例如 www.baidu.com 80
            server.connect(address, 3000);
            System.out.println("ok!");
            log.info("连通性正常...");
            return true;
        }
        catch (UnknownHostException e) {
            log.info("连通性异常...");
            e.printStackTrace();
        } catch (IOException e) {
            log.info("连通性异常...");
            e.printStackTrace();
        }
        return false;
    }
}
