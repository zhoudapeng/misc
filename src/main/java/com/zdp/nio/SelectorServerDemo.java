package com.zdp.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
@author  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date 2015年9月2日 下午5:29:12
 */
public class SelectorServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(9090));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            try{
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                for(SelectionKey key:keys) {
                    if (!key.isValid()) {
                        System.out.println("key is invalid");
                        continue;
                    }
                    if (key.isAcceptable()) {
                        ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                        SocketChannel sc = ssc.accept();
                        if (sc == null) {
                            continue;
                        }
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel)key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int count = sc.read(buffer);
                        System.out.println("server received request:" + new String(buffer.array(),0,count));
                        String content = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                        sc.write(ByteBuffer.wrap(content.getBytes()));
                        sc.close();
                    }
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
