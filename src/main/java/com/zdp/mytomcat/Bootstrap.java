package com.zdp.mytomcat;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dapeng.zhou on 2016/2/19.
 */
public class Bootstrap {
    private static final String SHUTDOWN = "SHUTDOWN";
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            boolean shutdown = false;
            while (true) {
                try{
                    Socket socket = serverSocket.accept();
                    System.out.println(socket);
                    InputStream inputStream = socket.getInputStream();
                    Request request = Converter.convert(inputStream);
                    if (SHUTDOWN.equals(request.getUri())) {
                        shutdown = true;
                        break;
                    }
                    OutputStream outputStream = socket.getOutputStream();
                    Response response = new Response(request,outputStream);
                    response.sendStaticResource();
                    socket.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
