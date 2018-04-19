package com.zdp.threadmodel.nio.netty.like;

import com.google.common.collect.Lists;

import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Random;

/**
 * Created by dapeng.zhou on 2017/4/6.
 */
public class EventLoopExecutor {
    private List<Allocatable<SocketChannel>> handlers = Lists.newArrayList();
    private Random rd = new Random();

    public EventLoopExecutor(int size) {
        for (int i = 0; i < size; i++) {
            WorkerThread workerThread = new WorkerThread();
            Thread thread = new Thread(workerThread);
            thread.start();
            handlers.add(workerThread);
        }
    }

    public void handle(SocketChannel socketChannel) {
        Allocatable<SocketChannel> handler = random();
        handler.allocate(socketChannel);
    }

    private Allocatable<SocketChannel> random() {
        return handlers.get(rd.nextInt(handlers.size()));
    }
}
