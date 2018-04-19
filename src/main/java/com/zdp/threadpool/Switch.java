package com.zdp.threadpool;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dapeng.zhou on 2016/8/5.
 */
public class Switch {
    ExecutorService threadPool;

    public void switchPool() {
        ExecutorService old = threadPool;
        ExecutorService newPool = Executors.newCachedThreadPool();
        threadPool = newPool;
        old.shutdownNow();
    }

    @PostConstruct
    public void init () {
        threadPool = Executors.newCachedThreadPool();
    }
}
