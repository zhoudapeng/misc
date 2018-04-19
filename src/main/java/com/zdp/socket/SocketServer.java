package com.zdp.socket;

import org.apache.commons.lang.time.FastDateFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2014年12月1日 下午5:21:11
 */
public class SocketServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        OutputStream output = null;
        Socket socket = null;
        try {
            while (true) {
                socket = serverSocket.accept();
                InputStream input = socket.getInputStream();
                byte[] buffer = new byte[1024];
                input.read(buffer);
                output = socket.getOutputStream();
                output.write(("the time is " + FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date())).getBytes());
                output.flush();
                output.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
