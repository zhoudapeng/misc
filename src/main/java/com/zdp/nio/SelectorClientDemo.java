package com.zdp.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date 2015年9月2日 下午6:33:33
 */
public class SelectorClientDemo {
    private static AtomicInteger counter = new AtomicInteger(1);
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        while(true) {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9090));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            write(socketChannel);
            selector.select(1000);
            Set<SelectionKey> keys = selector.selectedKeys();
            for (SelectionKey key : keys) {
                if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }
    
    private static void read(SelectionKey key) throws Exception {
        SocketChannel sc = (SocketChannel)key.channel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int count = sc.read(buf); 
        if (count > 0) {
            String content = "client received data：" + new String(buf.array(),0,count);
            System.out.println(content);
        }
    }
    
    private static void write(SocketChannel sc) throws Exception{
        sc.write(ByteBuffer.wrap((("RequestID[" + counter.getAndIncrement() + "]what is the time now?").getBytes())));
    }
}
