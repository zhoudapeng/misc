package com.zdp.threadmodel.nio.netty.like;

import com.zdp.threadmodel.Util;
import org.apache.commons.collections.CollectionUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by dapeng.zhou on 2017/4/1.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9090));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            if (CollectionUtils.isEmpty(selectionKeys)) {
                System.out.println(Thread.currentThread() + "未轮询到事件");
                Thread.sleep(2000);
            }
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isConnectable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_WRITE);
                }
                if (selectionKey.isWritable()) {
                    System.out.println("write...");
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    channel.write(ByteBuffer.wrap("what is the time?".getBytes()));
                    channel.register(selector, SelectionKey.OP_READ);
                }
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    System.out.println("什么情况啊?from=" + channel.hashCode());
                    System.out.println("receive response:" + new String(buffer.array()));
                }
                System.out.println("remove " + selectionKey);
                iterator.remove();
            }
        }
    }
}
