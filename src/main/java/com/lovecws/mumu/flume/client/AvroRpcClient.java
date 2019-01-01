package com.lovecws.mumu.flume.client;

import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.SimpleEvent;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * @author babymm
 * @version 1.0-SNAPSHOT
 * @Description: 连接远程avro连接, 将日志信息发送到远程flume服务器上
 * @date 2017-10-19 11:35
 */
public class AvroRpcClient {

    private static final Logger logger = Logger.getLogger(AvroRpcClient.class);

    public static void main(String[] args) {
        RpcClient rpcClient = RpcClientFactory.getDefaultInstance("192.168.0.25", 44444, 10);
        SimpleEvent simpleEvent = new SimpleEvent();
        try {
            for (int i = 0; i < 100; i++) {
                simpleEvent.setBody(("lovecws" + new Date().toLocaleString()).getBytes());
                rpcClient.append(simpleEvent);
                logger.info(new String(simpleEvent.getBody()));
            }
        } catch (EventDeliveryException e) {
            e.printStackTrace();
        } finally {
            rpcClient.close();
            System.exit(-1);
        }
    }
}
