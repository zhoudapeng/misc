package com.zdp.mytomcat;

import sun.misc.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by dapeng.zhou on 2016/2/19.
 */
public class Response {
    private Request request;
    private OutputStream outputStream;

    public Response() {
    }

    public Response(Request request,OutputStream outputStream) {
        this.request = request;
        this.outputStream = outputStream;
    }

    public void sendStaticResource() throws Exception{
        System.out.println("send static resource");
        String uri = request.getUri();
        System.out.println(File.separator);
        String path = System.getProperty("user.dir") + uri.replace("/",File.separator);
        System.out.println("path="+path);
        File file = new File (path);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[2048];
        int i = -1;
        StringBuilder sb = new StringBuilder();
        while ((i = inputStream.read(buffer)) != -1) {
            sb.append(new String(buffer,0,i));
        }
        PrintWriter writer = new PrintWriter(outputStream,true);
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-type:text/html");
        writer.println();
        writer.println(sb);
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
