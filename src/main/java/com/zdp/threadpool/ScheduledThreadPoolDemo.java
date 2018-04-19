package com.zdp.threadpool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年1月23日 下午1:41:01
 */
public class ScheduledThreadPoolDemo {
    private static DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static void main(String[] args) {
        final ScheduledExecutorService  service = Executors.newScheduledThreadPool(2);
//        service.schedule(new Runnable(){
//
//            public void run() {
//                System.out.println("Execute at " + fmt.format(new Date()));
////                try {
////                    Thread.sleep(5000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//                throw new RuntimeException("I want to exit...");
//            }}, 5, TimeUnit.SECONDS);
        
//        service.schedule(new Runnable(){
//
//            public void run() {
//                System.out.println("Execute at " + fmt.format(new Date()));
//            }}, 5, TimeUnit.SECONDS);
        
        //Repeatable Task Demo
            while(true){
                service.schedule(new Runnable(){

                    public void run() {
                        System.out.println("Execute at " + fmt.format(new Date()));
                    }}, 2, TimeUnit.SECONDS);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
    }
}
