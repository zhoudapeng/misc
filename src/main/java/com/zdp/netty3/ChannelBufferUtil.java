package com.zdp.netty3;

import org.apache.commons.lang.StringUtils;
//import org.jboss.netty.buffer.ChannelBuffer;
//import org.jboss.netty.buffer.ChannelBuffers;
//import org.jboss.netty.channel.ChannelEvent;
//import org.jboss.netty.channel.MessageEvent;

import java.nio.charset.Charset;

/**
 * Created by dapeng.zhou on 2016/6/14.
 */
public class ChannelBufferUtil {
    /**
     * 从MessageEvent中读取输入信息
     * @param event
     * @return
     */
//    public static String read(MessageEvent event) {
//        ChannelBuffer buffer = (ChannelBuffer) event.getMessage();
//        return buffer.toString(Charset.defaultCharset());
//    }
//
//    /**
//     * 向MessageEvent中输出
//     * @param event
//     * @param msg
//     */
//    public static void write(ChannelEvent event, String msg) {
//        if (StringUtils.isEmpty(msg)) {
//            return;
//        }
//        byte[] bytes = msg.getBytes(Charset.defaultCharset());
//        ChannelBuffer buffer = ChannelBuffers.buffer(bytes.length);
//        buffer.writeBytes(bytes);
//        event.getChannel().write(buffer);
//    }

}
