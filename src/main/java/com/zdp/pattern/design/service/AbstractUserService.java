package com.zdp.pattern.design.service;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年2月5日 下午5:09:23
 */
public abstract class AbstractUserService implements UserService{
    public boolean pay(){
        return true;
    }
    public boolean cancel(){
        return true;
    }
    
}
