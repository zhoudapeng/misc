package com.zdp.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dapeng.zhou on 2016/10/9.
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.publishEvent(new MailEvent("","dapeng.zhou@qunar.com","恭喜","恭喜恭喜恭喜你呀，恭喜你呀恭喜你!"));
    }
}
