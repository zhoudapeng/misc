package com.zdp.barrier;

import com.github.rjeschke.txtmark.Run;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dapeng.zhou on 2017/3/31.
 */
public class BarrierDemo {
    public static void main(String[] args) {
        int count = 6;
        CyclicBarrier barrier = new CyclicBarrier(count);
        for (int i = 0;i < count;i++) {
            new Thread(new Player(barrier)).start();
        }
    }
}

class Player implements Runnable {
    private CyclicBarrier barrier;
    public Player(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        System.out.println(Thread.currentThread() + "已经进入跑道，等待其他选手进入跑道" );
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + "此时一共有" + barrier.getNumberWaiting()  + "名选手在等待");
            barrier.await();
            System.out.println(Thread.currentThread() + "所有选手都已进入跑道，开始跑啦");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread() + "已经跑完全程，等待所有队员跑完全程后向观众致谢，此时一共有" + barrier.getNumberWaiting() + "位选手已经跑完");
            barrier.await();
            System.out.println(Thread.currentThread() + "所有选手都已经到达终点，可以向观众致谢后立场啦");
        } catch (Exception e) {

        }
    }

    private int random() {
        Random rd = new Random();
//        return rd.nextInt(1000);
        return 1000;
    }

    private void doa() {
        if (true) {
            return;
        }
        ExecutorService service = Executors.newCachedThreadPool();
        final CyclicBarrier cb = new CyclicBarrier(3);// 创建CyclicBarrier对象并设置3个公共屏障点
        System.out.println("创建子线程开始");
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(
                                "线程" + Thread.currentThread().getName() + "即将到达集合地点1，当前已有" + (cb.getNumberWaiting() + 1)
                                        + "个已到达" + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等候"));
                        try {
                            cb.await();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(
                                "线程" + Thread.currentThread().getName() + "即将到达集合地点2，当前已有" + (cb.getNumberWaiting() + 1)
                                        + "个已到达" + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等候"));
                        try {
                            cb.await();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(
                                "线程" + Thread.currentThread().getName() + "即将到达集合地点3，当前已有" + (cb.getNumberWaiting() + 1)
                                        + "个已到达" + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等候"));
                        try {
                            cb.await();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
            System.out.println("子线程 "+ i + "提交到线程池中");
        }
        System.out.println("所有子线程提交完毕，线程池关闭,但线程池关闭的真实时间为所有子线程都执行完毕后");
        service.shutdown();//线程池的状态则立刻变成SHUTDOWN状态,以后不能再往线程池中添加任何任务，否则将会抛出RejectedExecutionException异常。但是，此时线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出。 与它相似的还有一个shutdownNow()，它通过调用Thread.interrupt来实现线程的立即退出。
    }
}
