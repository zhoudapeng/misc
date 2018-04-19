package com.zdp.threadmodel.bio.original;

import com.zdp.threadmodel.Util;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by dapeng.zhou on 2017/4/1.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(Util.PORT);
        System.out.println("server starting...");
        Socket socket = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            while (true) {
                socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
                String request = reader.readLine();
                System.out.println("receive request:" + request);
                writer = new BufferedWriter(new OutputStreamWriter(outputStream,"utf-8"));
                writer.write("the time is " + FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date()));
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            writer.close();
            reader.close();
            socket.close();
        }
    }
}
