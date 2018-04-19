package com.zdp.log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月19日 下午12:09:31
 */
public class LevelCheckDemo {
    private static final DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static void main(String[] args) {
        Log logger = LogFactory.getLog("CommonsLoggingDemo");
        logger.debug("the time is " + getTimeNow("debug"));
        logger.info("the time is " + getTimeNow("info"));
        if (logger.isDebugEnabled()){
            logger.debug("[after check] the time is " + getTimeNow("debug"));
        }
        if (logger.isInfoEnabled()){
            logger.info("[after check] the time is " + getTimeNow("info"));
        }
    }
    public static String getTimeNow(String tag){
        System.out.println("invoke method getTimeNow(),tag="+tag);
        return fmt.format(new Date());
    }
}
