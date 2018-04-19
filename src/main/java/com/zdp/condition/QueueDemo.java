package com.zdp.condition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by dapeng.zhou on 2016/6/30.
 */
public class QueueDemo {
    static Random rd = new Random();
    public static void main(String[] args) {
        BlockingQueue queue = new MyQueue();
        new Thread(new PutThread(queue)).start();
        new Thread(new TakeThread(queue)).start();
    }

    static class PutThread implements Runnable {
        private BlockingQueue queue;

        public PutThread(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            while (true) {
                String value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                queue.put(value);
                System.out.println("将" + value + "放入队列");
                try {
                    Thread.sleep(rd.nextInt(2) *1000 + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class TakeThread implements Runnable {
        private BlockingQueue queue;

        public TakeThread(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            while (true) {
                System.out.println("从队列取出"+queue.take());
                try {
                    Thread.sleep(rd.nextInt(3) * 1000 + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
