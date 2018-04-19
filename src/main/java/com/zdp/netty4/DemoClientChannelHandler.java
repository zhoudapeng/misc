package com.zdp.netty4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by dapeng.zhou on 2016/6/17.
 */
public class DemoClientChannelHandler extends SimpleChannelInboundHandler<String>{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("connect server success...");
        ctx.writeAndFlush("What is the time now?");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("receive response:" + msg);
    }
}
