package com.zdp.multithread;

import java.util.concurrent.BlockingQueue;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月23日 下午3:10:57
 */
public class Consumer <T> implements Runnable{
    
    private int index;
    
    private BlockingQueue<T> queue;
    public Consumer(int index,BlockingQueue<T> queue){
        this.index = index;
        this.queue = queue;
    }

    public void run() {
        while(true){
            try {
                System.out.println("Consumer["+index+"] consum random:"+queue.take());
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
