package com.zdp.concurrent;

import com.github.rjeschke.txtmark.Run;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by dapeng.zhou on 2017/6/15.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws Exception {
        int n = 5;
        CyclicBarrier barrier = new CyclicBarrier(n + 1, new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + " everything is done");
            }
        });
        for (int i = 0;i< n ;i++) {
            new Thread(new Worker(barrier)).start();
        }
        barrier.await();
        System.out.println(Thread.currentThread() + " continue executing...");
    }

    static class Worker implements Runnable {
        private CyclicBarrier barrier;
        public Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        public void run()  {
            try {
                System.out.println(Thread.currentThread() + " is ready");
                barrier.await();
                System.out.println(Thread.currentThread() + " continue executing...");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
