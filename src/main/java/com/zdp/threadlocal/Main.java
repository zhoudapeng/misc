package com.zdp.threadlocal;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年4月17日 下午1:27:20
 */
public class Main {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++){
//            new SimpleThread().start();
            executor.execute(new SimpleThread());
        }
    }
}

class SimpleThread extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            String str = SimpleThreadLocal.get();
            System.out.println(Thread.currentThread()+"----"+i+"----"+str);
            SimpleThreadLocal.set(str+"1");
            this.yield();
        }
        SimpleThreadLocal.remove();
    }
}
