package com.zdp.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dapeng.zhou on 2016/6/30.
 */
public class MyQueue implements BlockingQueue<String>{
    private int CAPACITY = 4;
    private List<String> datas = new ArrayList<String>(CAPACITY);
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public void put(String value) {
        try {
            lock.lock();
            if (datas.size() == CAPACITY) {
                System.out.println("现在队列满了，等待conditon");
                notFull.await();
            }
            datas.add(value);
            notEmpty.signal();
        }catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }

    public String take() {
        try{
            lock.lock();
            if (datas.isEmpty()) {
                System.out.println("现在对了为空，等待条件");
                notEmpty.await();
            }
            notFull.signal();
            return datas.remove(0);
        }catch (Exception e) {

        }finally {
            lock.unlock();
        }
        return null;
    }
}
