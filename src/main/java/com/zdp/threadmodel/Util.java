package com.zdp.threadmodel;

import javafx.beans.binding.StringBinding;
import org.apache.commons.lang.time.FastDateFormat;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by dapeng.zhou on 2017/4/1.
 */
public class Util {
    public static final int PORT = 7070;

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static String read(InputStream inputStream) throws Exception {
        byte[] buffer = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int n = -1;
        while ((n = inputStream.read(buffer)) != -1) {
            sb.append(new String(buffer,0,n));
        }
        return sb.toString();
    }

    public static String time() {
        return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static void write(OutputStream outputStream, String value) throws Exception {
        outputStream.write(value.getBytes());
    }

    public static String buildResponse(String request) {
        return "process success,request=" + request + ",response=" + FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss" + "\n\r");
    }

    public static void main(String[] args) {
        System.out.println(LINE_SEPARATOR);
    }
}
