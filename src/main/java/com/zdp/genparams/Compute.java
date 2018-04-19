package com.zdp.genparams;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by dapeng.zhou on 2016/4/8.
 */
public class Compute {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\total.txt")));
        String value = "";
        int total = 0;
        while(true) {
            value = reader.readLine();
            if (StringUtils.isEmpty(value)) {
                break;
            }
            total += Integer.valueOf(value);
        }
        System.out.println(total);
    }
}
