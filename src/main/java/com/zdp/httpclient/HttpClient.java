package com.zdp.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by dapeng.zhou on 2016/2/19.
 */
public class HttpClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("zdpwin.com",80);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream,true);
            writer.println("GET / HTTP/1.1");
            writer.println("Connection: Keep-Alive");
//            writer.println("Host:zdpwin.com");
            writer.println();
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int i = -1;
            StringBuilder sb = new StringBuilder();
            while((i = inputStream.read(buffer)) != -1) {
                sb.append(new String(buffer));
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
