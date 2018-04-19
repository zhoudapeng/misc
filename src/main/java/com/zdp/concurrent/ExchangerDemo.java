package com.zdp.concurrent;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Created by dapeng.zhou on 2017/6/15.
 */
public class ExchangerDemo {
    static Random rd = new Random();

    public static void main(String[] args) {
        Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();
        Worker worker1 = new Worker(exchanger);
        Worker worker2 = new Worker(exchanger);
        new Thread(worker1).start();
        new Thread(worker2).start();
    }

    static class Worker implements Runnable {
        Exchanger<List<Integer>> exchanger;
        public Worker(Exchanger<List<Integer>> exchanger) {
            this.exchanger = exchanger;
        }
        public void run() {
            try {
                List<Integer> list = Lists.newArrayList();
                list.add(rd.nextInt());
                list.add(rd.nextInt());
                System.out.println(Thread.currentThread() + " create list:" + list);
                List<Integer> exchangedList =  exchanger.exchange(list);
                System.out.println(Thread.currentThread() + " list after exchanged:" + exchangedList);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
