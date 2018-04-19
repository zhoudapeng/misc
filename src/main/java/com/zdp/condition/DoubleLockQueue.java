package com.zdp.condition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dapeng.zhou on 2017/4/26.
 */
public class DoubleLockQueue implements BlockingQueue<String> {
    private static int CAPACITY = 4;
    private List<String> datas = new ArrayList<String>();
    private Lock readLock = new ReentrantLock();
    private Condition notEmpty = readLock.newCondition();
    private Lock writeLock = new ReentrantLock();
    private Condition notFull = writeLock.newCondition();
    public void put(String value) {
        try {
            writeLock.lock();
            if (datas.size() == CAPACITY) {
                notFull.await();
            }
            datas.add(value);
            try {
                readLock.lock();
                notEmpty.signal();
            }finally {
                readLock.unlock();
            }
        } catch (Exception e) {

        }finally {
            writeLock.unlock();
        }
    }

    public String take() {
        return null;
    }
}
