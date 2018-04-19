package com.zdp.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;

/**
 * Created by dapeng.zhou on 2017/7/6.
 */
public class SynchronizedQueue {
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.valueOf("0V",36));
        SynchronousQueue<String> queue = new SynchronousQueue<String>();
        queue.offer("a");
        System.out.println("put b");
        queue.offer("b");
        System.out.println("put c");
        queue.offer("c");
//        Executor executor = Executors.newCachedThreadPool();
//        executor.execute(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        executor.execute(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }


}
