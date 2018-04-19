package com.zdp.pattern.design.service;
/**
 *需要做分发的接口
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年2月5日 下午5:08:43
 */
public interface NeedDispatchedUserService {
    public boolean book(BookCommand command);
}
