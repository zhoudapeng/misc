package com.zdp.log;

import org.apache.log4j.Logger;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月19日 上午9:57:02
 */
public class Log4jDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Log4jDemo");
        logger.info("我是log4j...");
        logger.info("秒掉zdp-logging");
    }
}
