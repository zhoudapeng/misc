package com.zdp.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dapeng.zhou on 2017/6/15.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        int n = 5;
        CountDownLatch latch = new CountDownLatch(n + 1);
        for (int i=0;i < n;i++) {
            new Thread(new Worker(latch)).start();
        }
        latch.await();
        System.out.println("all done");
    }

    static class Worker implements Runnable {
        private CountDownLatch latch;
        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            System.out.println(Thread.currentThread() + " finished...");
            latch.countDown();
        }
    }
}
