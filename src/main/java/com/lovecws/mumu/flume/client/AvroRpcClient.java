package com.lovecws.mumu.flume.client;

import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.SimpleEvent;

/**
 * @author babymm
 * @version 1.0-SNAPSHOT
 * @Description: TODO
 * @date 2017-10-19 11:35
 */
public class AvroRpcClient {
    public static void main(String[] args) {
        RpcClient rpcClient = RpcClientFactory.getDefaultInstance("192.168.11.25", 10000, 10);
        SimpleEvent simpleEvent = new SimpleEvent();
        simpleEvent.setBody("lovecws".getBytes());
        try {
            for (int i = 0; i < 100; i++) {
                rpcClient.append(simpleEvent);
            }
        } catch (EventDeliveryException e) {
            e.printStackTrace();
        }
    }
}
