package com.zdp.log;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月19日 下午2:08:01
 */
public class Slf4jLogFmtDemo {
    
    
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("Slf4jDemo");
        logger.debug("hi,all,我是slf4j,有了我，你们从此就可以不用自己显示的判断你的日志需不需要输出了，都交给我来干吧"+System.currentTimeMillis());
        logger.info("原始方式,不管级别够不够都会发生字符串拼接:logInfo=["+System.currentTimeMillis()+"|"+getRandomInt()+"]");
        logger.info("新的方式,只有级别够了才会拼接:logInfo=[{}|{}]",System.currentTimeMillis(),getRandomInt());
    }
    
    public static int getRandomInt(){
        Random rd = new Random();
        return rd.nextInt(100);
    }
    
}
