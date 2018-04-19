package com.zdp.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月23日 下午2:56:51
 */
public class Producer_Consumer {
    //生产者数量
    private static final int PRODUCER_COUNT = 4;
    //消费者数量
    private static final int CONSUMER_COUNT = 10;
    
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        ExecutorService producerService = Executors.newFixedThreadPool(PRODUCER_COUNT);
        ExecutorService consumerService = Executors.newFixedThreadPool(CONSUMER_COUNT);
        final AtomicInteger n = new AtomicInteger();
        GetRandomValueable<String> getRandom = new GetRandomValueable<String>() {
            public String getRandomValue() {
                return String.valueOf(n.getAndAdd(1));
            }
        };
        for(int i=0;i<PRODUCER_COUNT;i++){
            producerService.execute(new Producer<String>(i,queue,getRandom));
        }
        for(int i=0;i<=CONSUMER_COUNT;i++){
            consumerService.execute(new Consumer<String>(i,queue));
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
