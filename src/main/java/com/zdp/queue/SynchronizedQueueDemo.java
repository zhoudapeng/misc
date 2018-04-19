package com.zdp.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年1月21日 下午3:07:28
 */
public class SynchronizedQueueDemo {
    public static void main(String[] args) {
        BlockingQueue queue = new SynchronousQueue();
        Thread takeThread = new Thread(new TakeThread(queue));
        Thread putThread1 = new Thread(new PutThread(queue));
        Thread putThread2 = new Thread(new PutThread(queue));
        takeThread.start();
        putThread1.start();
        putThread2.start();
    }
    
    static class TakeThread implements Runnable{
        
        private BlockingQueue queue;
        
        public TakeThread(BlockingQueue queue){
            this.queue = queue;
        }

        public void run() {
            while(true){
                try {
                    System.out.println("take from queue--"+queue.take() +"--size="+queue.size());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    static class PutThread implements Runnable{
        private BlockingQueue queue;
        public PutThread(BlockingQueue queue){
            this.queue = queue;
        }
        public void run() {
            System.out.println(Thread.currentThread()+"start...");
            int n = 0;
            while(true){
                try {
                    queue.put(Thread.currentThread()+""+n++);
                    System.out.println(Thread.currentThread()+"put "+n+" to queue");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
