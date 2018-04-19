package com.zdp.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by dapeng.zhou on 2017/6/15.
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(6);
    public static void main(String[] args) {
        new Thread(new Worker(semaphore)).start();
        new Thread(new Worker(semaphore)).start();
    }

    static class Worker implements Runnable {
        private Semaphore semaphore;
        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        public void run() {
            try {
                semaphore.acquire(5);
                System.out.println(Thread.currentThread() + " permit executing...");
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread() + " release semaphore");
                semaphore.release(1);
            }
        }
    }
}
