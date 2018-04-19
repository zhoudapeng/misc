package com.zdp.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by dapeng.zhou on 2016/4/18.
 */
public class NIOServer {
    public static void main(String[] args) {
        try{
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(9090));
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            new Thread(new ServerReactorThread((selector))).start();
        }catch (Exception e) {
            System.exit(1);
        }
    }

    public static class ServerReactorThread implements Runnable{
        private Selector selector;

        public ServerReactorThread(Selector selector) {
            this.selector = selector;
        }

        public void run() {
            while (true) {
                try{
                    int n = selector.select(1000);
                    if (n <= 0) {
                        continue;
                    }
                    Set<SelectionKey> keys = selector.selectedKeys();
                    for (SelectionKey key:keys) {
                        if (key.isAcceptable()) {
                            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                            SocketChannel channel = ssc.accept();
                            if (channel == null) {
                                continue;
                            }
                            System.out.println("accept a connection...");
                            channel.configureBlocking(false);
                            channel.register(selector,SelectionKey.OP_READ);
                        }
                        if (key.isReadable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            channel.read(buffer);
                            String input = new String(buffer.array());
                            System.out.println("request from request :" + input );
                            channel.register(selector,SelectionKey.OP_WRITE);
                        }
                        if (key.isWritable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            channel.write(ByteBuffer.wrap("I am server".getBytes()));
                        }
                    }
                    Thread.sleep(2000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


