package com.zdp.multithread;

import java.util.concurrent.BlockingQueue;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月23日 下午2:58:59
 */
public  class Producer <T> implements Runnable{
    
    private int index;
    
    private BlockingQueue<T> queue;
    
    private GetRandomValueable<T> randomGenerator;
    
    public Producer(int index,BlockingQueue<T> queue,GetRandomValueable<T> randomGenerator){
        this.index = index;
        this.queue = queue;
        this.randomGenerator = randomGenerator;
    }

    public void run() {
        while(true){
            try {
                T t = randomGenerator.getRandomValue();
//                System.out.println("Pruducer["+index+"] create random:" + t);
                boolean result = queue.offer(t);
                System.out.println("Producer["+index+"] offer "+result);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }  
}
