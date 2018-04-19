package com.zdp.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by dapeng.zhou on 2016/10/9.
 */
public class SimpleFuture<V> implements Future<V> {
    private V value;

    public SimpleFuture(V value) {
        this.value = value;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return mayInterruptIfRunning;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public V get() throws InterruptedException, ExecutionException {
        return value;
    }

    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return value;
    }
}
