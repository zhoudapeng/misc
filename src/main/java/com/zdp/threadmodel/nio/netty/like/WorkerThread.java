package com.zdp.threadmodel.nio.netty.like;

import com.zdp.threadmodel.Util;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by dapeng.zhou on 2017/4/6.
 */
public class WorkerThread implements Runnable,Allocatable<SocketChannel>{
    private Selector selector;

    public WorkerThread(){
        try {
            this.selector = Selector.open();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                int count = selector.selectNow();
                if (count == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        socketChannel.read(byteBuffer);
                        String request = new String(byteBuffer.array());
                        System.out.println("receive request:" + request);
                        socketChannel.register(selector,SelectionKey.OP_WRITE,"the time is " + Util.time());
                    }
                    if (selectionKey.isWritable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        String response = (String)selectionKey.attachment();
                        socketChannel.write(ByteBuffer.wrap(response.getBytes()));
                    }
                    System.out.println("remove " + selectionKey);
                    iterator.remove();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void allocate(SocketChannel socketChannel) {
        try {
            socketChannel.register(selector,SelectionKey.OP_READ);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
