package com.zdp.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dapeng.zhou on 2016/6/30.
 */
public class PrinterMain {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition printA = lock.newCondition();
        Condition printB = lock.newCondition();
        Condition printC = lock.newCondition();
        Printer a = new Printer("a",lock,printA,printB);
        Printer b = new Printer("b",lock,printB,printC);
        Printer c = new Printer("c",lock,printC,printA);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
        try {
            lock.lock();
            printA.signal();
        }catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
