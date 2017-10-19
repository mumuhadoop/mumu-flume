package com.lovecws.mumu.flume.client;

import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.SimpleEvent;

/**
 * @author babymm
 * @version 1.0-SNAPSHOT
 * @Description: TODO
 * @date 2017-10-19 14:06
 */
public class ThriftRpcClient {

    public static void main(String[] args) throws EventDeliveryException {
        RpcClient rpcClient = RpcClientFactory.getThriftInstance("192.168.11.25", 10000);
        for (int i = 0; i < 1000; i++) {
            SimpleEvent simpleEvent = new SimpleEvent();
            simpleEvent.setBody("lovecws".getBytes());
            rpcClient.append(simpleEvent);
        }
    }
}
