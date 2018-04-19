package com.zdp.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2014年12月2日 下午2:58:12
 */
public class MyThreadPool {

    private int DEFAULT_QUEUE_MAX_SIZE = 5;

    private BlockingQueue<Runnable> queue = null;

    public MyThreadPool() {
        this(5);
    }

    public MyThreadPool(int poolSize) {
        if (poolSize <= 0){
            throw new RuntimeException("你丫的在玩我吗？");
        }
        init(poolSize);
    }

    public boolean execute(Runnable runnable) {
        if (queue.size() == DEFAULT_QUEUE_MAX_SIZE) {
            System.out.println("Queue is full,so abandon your task " + runnable.toString());
            return false;
        }
        System.out.println("Add Task " + runnable.toString());
        queue.offer(runnable);
        return true;
    }

    private void init(int poolSize) {
        queue = new ArrayBlockingQueue<Runnable>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            Thread thread = new Thread(new WorkerThread());
            thread.start();
        }
    }

    class WorkerThread implements Runnable {

        public void run() {
            while (true) {
                Runnable runnable;
                try {
                    runnable = queue.take();
                    runnable.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThread implements Runnable {
        int n;

        public MyThread(int n) {
            this.n = n;
        }

        @Override
        public String toString() {
            return "MyThread [" + n + "]";
        }

        public void run() {
            System.out.println("MyThread[" + n + "] running...");
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool();
        for (int i = 0; i < 20; i++) {
            pool.execute(new MyThread(i));
        }
    }
}
