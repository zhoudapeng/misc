package com.zdp.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年5月4日 下午5:40:18
 */
public class BIOCopy {
    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
        File fromFile = new File("4.王磊--微服务，大探险.pdf");
        File toFile = new File("bio-toFile.pdf");
        FileInputStream inStream = new FileInputStream(fromFile);
        FileOutputStream outStream = new FileOutputStream(toFile);
        byte[] buffer = new byte[1024];
        int n = -1;
        while((n=inStream.read(buffer))!=-1){
            outStream.write(buffer, 0, n);
        }
        outStream.close();
        inStream.close();
        System.out.println("bio elapse="+(System.currentTimeMillis() - begin));
    }
}
