package com.zdp.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年5月4日 下午2:23:45
 */
public class FileChannelDemo {
    public static void main(String[] args) throws Exception {
        write();
        read();
    }
    
    private static void read() throws Exception{
        File file = new File("data.txt");
        FileInputStream inStream = new FileInputStream(file);
        //获取通道
        FileChannel channel = inStream.getChannel();
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读取数据到缓冲区
        channel.read(buffer);
        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }
        channel.close();
        inStream.close();
    }
    
    private static void write() throws Exception{
        File file = new File("data.txt");
        FileOutputStream output = new FileOutputStream(file);
        FileChannel channel = output.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("I am learning NIO,hah!".getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.close();
        output.close();
    }
}
