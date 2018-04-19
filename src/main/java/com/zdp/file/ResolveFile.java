package com.zdp.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年8月13日 下午4:46:50
 */
public class ResolveFile {
    public static void main(String[] args) throws Exception {
        FileInputStream inStream = new FileInputStream(new File("D:/需求/08-13批量发券/mobiles.txt"));
        FileOutputStream outStream = new FileOutputStream(new File("D:/需求/08-13批量发券/mobiles_new.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
        byte[] buffer = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int n = -1;
        while((n = inStream.read(buffer)) != -1){
            sb.append(new String(buffer,0,n));
        }
        String[] mobiles = sb.toString().split(",");
        System.out.println(mobiles.length);
        for(String mobile:mobiles){
            System.out.println(mobile);
            writer.write(mobile+"\n");
        }
        writer.flush();
    }
}
