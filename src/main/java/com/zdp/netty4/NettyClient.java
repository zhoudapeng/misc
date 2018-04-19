package com.zdp.netty4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dapeng.zhou on 2016/6/17.
 */
public class NettyClient {
    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                    ch.pipeline().addLast("decoder",new StringDecoder());
                    ch.pipeline().addLast("encoder",new StringEncoder());
                    ch.pipeline().addLast(new DemoClientChannelHandler());
                }
            });
            ChannelFuture future = bootstrap.connect("127.0.0.1",9090).sync();
            Channel channel = future.channel();
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input = reader.readLine();
                channel.writeAndFlush(input + "\n");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
        }
    }
}
