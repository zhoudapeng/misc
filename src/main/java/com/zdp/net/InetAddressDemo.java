package com.zdp.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年7月20日 下午10:30:59
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress[] addrs = InetAddress.getAllByName("www.baidu.com");
            for(InetAddress addr:addrs){
                System.out.println(addr);
            }
            System.out.println(InetAddress.getByName("220.181.111.111").getHostName());
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
