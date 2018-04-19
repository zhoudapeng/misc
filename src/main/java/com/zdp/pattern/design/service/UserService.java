package com.zdp.pattern.design.service;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年2月5日 下午5:08:20
 */
public interface UserService extends NeedDispatchedUserService{
    public boolean pay();
    public boolean cancel();
}
