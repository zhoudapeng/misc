package com.zdp.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年1月22日 下午6:03:00
 */
public class Demo {
    public static void main(String[] args) {
        ExecutorService service =  new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        service.execute(new Runnable(){

            public void run() {
                System.out.println("run...");
            }});
    }
}
