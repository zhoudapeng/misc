package com.zdp.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年7月16日 下午4:35:57
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(){
            public void run(){
                try {
                    Thread.sleep(100);
                    System.out.println("hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println(executor.isShutdown());
        executor.execute(t);
        System.out.println("stop");
        Thread.sleep(500);
        System.out.println(executor.isShutdown());
    }
}
