package com.zdp.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by dapeng.zhou on 2016/4/18.
 */
public class NIOClient {
    public static void main(String[] args) {
        try{
            Selector selector = Selector.open();
            new Thread(new ClientReactorThread(selector)).start();
        }catch (Exception e) {
            System.exit(1);
        }
    }

    public static class ClientReactorThread implements Runnable {

        private Selector selector;

        public ClientReactorThread(Selector selector) {
            this.selector = selector;
        }

        public void run() {
            while (true) {
                try{
                    SocketChannel ch = SocketChannel.open();
                    ch.configureBlocking(false);
                    ch.connect(new InetSocketAddress("127.0.0.1",9090));
                    ch.register(selector, SelectionKey.OP_CONNECT);
                    int n = selector.select(1000);
                    if (n <= 0) {
                        continue;
                    }
                    Set<SelectionKey> keys = selector.selectedKeys();
                    for (SelectionKey key:keys) {
                        if (key.isConnectable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            if (channel.isConnectionPending()) {
                                channel.finishConnect();
                            }
                            channel.configureBlocking(false);
                            channel.register(selector,SelectionKey.OP_WRITE);
                        }
                        if (key.isReadable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            channel.read(buffer);
                            String input = new String(buffer.array());
                            System.out.println("response from server :" + input );
                        }
                        if (key.isWritable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            channel.write(ByteBuffer.wrap("I am client".getBytes()));
                            channel.register(selector,SelectionKey.OP_READ);
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
