package com.zdp.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月19日 上午10:11:29
 */
public class CommonsLoggingDemo {
    public static void main(String[] args) {
        Log logger = LogFactory.getLog("CommonsLoggingDemo");
        logger.info("大家好，我就是你们心里的大神----commons-logging");
        logger.info("有技术就是任性");
    }
}
