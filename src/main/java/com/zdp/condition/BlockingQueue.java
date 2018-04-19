package com.zdp.condition;

/**
 * Created by dapeng.zhou on 2016/6/30.
 */
public interface BlockingQueue<T> {
    public void put(T value);

    public T take();
}
