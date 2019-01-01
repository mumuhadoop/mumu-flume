package com.lovecws.mumu.flume.connector;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * 输出日志到flume的avro的接收器
 */
public class WriteLog {
    private static final Logger logger = Logger.getLogger(WriteLog.class);

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            // 每隔两秒log输出一下当前系统时间戳
            logger.info(new Date().getTime());
            //System.out.println(new Date().getTime());
            Thread.sleep(1000);
            try {
                throw new Exception("exception msg");
            } catch (Exception e) {
                logger.error("error:" + e.getMessage());
            }
        }
    }
}