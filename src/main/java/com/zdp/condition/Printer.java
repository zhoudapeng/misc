package com.zdp.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by dapeng.zhou on 2016/6/30.
 */
public class Printer implements Runnable{
    private String name;
    private Lock lock;
    private Condition holdCondition;
    private Condition notifyCondition;

    public Printer(String name, Lock lock, Condition holdCondition, Condition notifyCondition) {
        this.name = name;
        this.lock = lock;
        this.holdCondition = holdCondition;
        this.notifyCondition = notifyCondition;
    }

    public void run() {
        while (true) {
            try{
                lock.lock();
                holdCondition.await();
                System.out.println(name + "...");
                Thread.sleep(1000);
                notifyCondition.signal();
            }catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }
}
