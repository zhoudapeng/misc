package com.zdp.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月19日 下午12:27:53
 */
public class Slf4jLogDemo {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("Slf4jDemo");
        logger.info("我是高大上的slf4j，有我在，什么都不用怕");
        logger.info("不要迷恋哥，哥只是一个传说");
    }
}
