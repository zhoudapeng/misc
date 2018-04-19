package com.zdp.proxy;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月11日 下午2:01:19
 */
public class User{
    public void printName(String name){
        if (name == null || name.length() == 0){
            throw new RuntimeException("Are you joking?");
        }
        System.out.println("Hello,my name is "+name);
    }
}
