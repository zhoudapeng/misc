package com.zdp.perf4j;

import java.util.Random;

import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年2月27日 上午10:33:55
 */
public class Perf4jDemo {
    public static void main(String[] args) {
        while(true){
            StopWatch stopWatch = new Log4JStopWatch();
            stopWatch.setTag("feed.get");
            try {
                int n = getRandom();
                Thread.sleep(n);
                stopWatch.stop();
                System.out.println("sleep "+n+" ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static int getRandom(){
        Random rd = new Random();
        return rd.nextInt(7)+1;
    }
}
