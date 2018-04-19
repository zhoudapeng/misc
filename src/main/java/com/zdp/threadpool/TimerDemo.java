package com.zdp.threadpool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer是单线程作业，这里要演示的是单线程作业的弊端<br/>
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年1月22日 上午11:25:42
 */
public class TimerDemo {
    
    private static DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws Exception {     
        Calendar calendar = new GregorianCalendar();
        Timer timer = new Timer();
        calendar.add(Calendar.SECOND, 5);
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                System.out.println("Execute at " + fmt.format(new Date()));
                throw new RuntimeException("I want to exit...");
//                try {
//                    Thread.sleep(5000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }}, calendar.getTime());
        
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                System.out.println("Execute at " + fmt.format(new Date()));
            }}, calendar.getTime());
    }
}
