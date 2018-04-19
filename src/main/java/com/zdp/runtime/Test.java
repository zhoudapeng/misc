package com.zdp.runtime;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.sql.Timestamp;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年7月9日 下午5:12:03
 */
public class Test {
    public static void main(String[] args) {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        char ch = 64;
        System.out.println(ch);
        System.out.println(new Timestamp(System.currentTimeMillis()).toString());
        System.out.println(name);
    }
}
