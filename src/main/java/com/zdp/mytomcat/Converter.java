package com.zdp.mytomcat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dapeng.zhou on 2016/2/19.
 */
public class Converter {
    public static Request convert(InputStream inputStream) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder sb = new StringBuilder();
//        String temp = null;
//        while ((temp = reader.readLine()) != null) {
//            sb.append(new String(temp));
//        }
        String firstLine = reader.readLine();
        System.out.println("firstLine=" + firstLine);
        String[] strs = firstLine.split(" ");
        String uri = strs[1];
        Request request = new Request();
        request.setUri(uri);
        return request;
    }
}
