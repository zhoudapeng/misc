package com.zdp.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年3月9日 下午8:45:48
 */
public class DecoderDemo {
    public static void main(String[] args) {
        String str = "http%3A%2F%2Fcardev.qunar.com%2Fm%2Fnative_coupon_list%3Ftoken%3D";
        try {
            System.out.println(URLDecoder.decode(str, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
