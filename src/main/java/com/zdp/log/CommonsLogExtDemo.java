package com.zdp.log;

import java.util.ArrayList;
import java.util.List;


/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月19日 下午3:34:20
 */
public class CommonsLogExtDemo {
    public static void main(String[] args) {
//        System.setProperty("org.apache.commons.logging.LogFactory", "com.zdp.log.MyLogFactory");
//        Log logger = LogFactory.getLog("zdp");
//        logger.info("abddcdd");
        List<String> aa = new ArrayList<String>();
        List<String> a = new ArrayList<String>();
        aa.removeAll(a);
        System.out.println(aa);
    }
}
