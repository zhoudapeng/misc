package com.zdp.threadmodel.bio.threadperconnection;

import com.zdp.threadmodel.Util;
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
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new RequestHandlerThread(socket)).start();
        }
    }
}
