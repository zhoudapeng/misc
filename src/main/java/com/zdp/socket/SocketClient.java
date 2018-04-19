package com.zdp.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2014年12月1日 下午7:47:14
 */
public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9090);
            OutputStream output = socket.getOutputStream();
            output.write("what is the time?".getBytes());
            output.flush();
            InputStream input = socket.getInputStream();
            byte[] buffer = new byte[1024];
            input.read(buffer);
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
