package com.zdp.reflect;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年5月6日 下午4:35:47
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(ReflectDemo.class.getMethod("get", null).getReturnType());
        Class clazz = ReflectDemo.class.getMethod("get", null).getReturnType();
    }
    
    public static int get(){
        return 0;
    }
}
