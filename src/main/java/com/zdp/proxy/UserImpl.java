package com.zdp.proxy;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月11日 下午2:45:50
 */
public class UserImpl implements IUser{

    public void printName(String name) {
        System.out.println("hello,my name is " + name);
    }

}
