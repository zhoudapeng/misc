package com.zdp.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年3月26日 下午5:22:47
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SimpleBean bean1 = (SimpleBean) context.getBean("bean1");
        SimpleBean bean2 = (SimpleBean) context.getBean("bean2");
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean1 == bean2);
        System.out.println(bean1.getIndex());
        System.out.println(bean2.getIndex());
    }
}
