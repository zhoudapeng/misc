package com.zdp.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年5月4日 下午5:22:19
 */
public class NIOCopy {
    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
        File fromFile = new File("4.王磊--微服务，大探险.pdf");
        File toFile = new File("nio-toFile.pdf");
        FileInputStream inStream = new FileInputStream(fromFile);
        FileOutputStream outStream = new FileOutputStream(toFile);
        FileChannel inChannel = inStream.getChannel();
        FileChannel outChannel = outStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            buffer.clear();
            int n=inChannel.read(buffer);
            if(n == -1){
                break;
            }
            buffer.flip();
            outChannel.write(buffer);
        }
        inChannel.close();
        inStream.close();
        outChannel.close();
        outStream.close();
        System.out.println("elapse="+(System.currentTimeMillis()-begin));
    }
}
