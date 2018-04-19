package com.zdp.netty4;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dapeng.zhou on 2016/6/17.
 */
public class DemoServerChannelHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("receive connection from " + ctx.channel().remoteAddress() );
        ctx.writeAndFlush("Welcome to time server\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("receive request:" + msg);
        ctx.writeAndFlush("The time is " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");
    }
}
