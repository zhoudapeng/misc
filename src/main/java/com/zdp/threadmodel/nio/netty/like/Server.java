package com.zdp.threadmodel.nio.netty.like;

import com.zdp.threadmodel.Util;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by dapeng.zhou on 2017/4/1.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(9090));
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        EventLoopExecutor executor = new EventLoopExecutor(2);
        // Reactor轮询
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys =  selector.selectedKeys();
            if (CollectionUtils.isEmpty(selectionKeys)) {
                Thread.sleep(2000);
                continue;
            }
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    executor.handle(socketChannel);
                }
                iterator.remove();
            }
        }
    }
}
