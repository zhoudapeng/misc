package com.zdp.multithread;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年7月17日 下午4:06:26
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<50;i++){
            Thread thread = new Thread(new MyThread(i));
            thread.setName("Mythread---"+i);
            executor.execute(thread);
        }
//        executor.shutdown();
        executor = null;
        Thread.sleep(5000);
        while(true){
            Runtime runtime = Runtime.getRuntime();
            long memory = runtime.freeMemory();
            System.out.println("free memory is "+memory);
            Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
            for(Map.Entry<Thread, StackTraceElement[]> entry:map.entrySet()){
                System.out.println(entry.getKey().getName());
            }
            System.out.println(Thread.getAllStackTraces().size());
            Thread.sleep(1000);
            System.gc();
        }
    }
}

class MyThread implements Runnable{
    private int index;
    public MyThread(int index){
        this.index = index;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("I am "+index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
