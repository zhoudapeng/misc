package com.zdp.pattern.design.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年2月5日 下午5:14:48
 */
@Service("userService")
public class UserServiceDispatcher extends AbstractUserService{
    @Resource
    private UserService userServiceImpl;
    @Resource
    private UserService userServicePackImpl;
    
    public boolean book(BookCommand command) {
        return getService(command.getOrderId()).book(command);
    }
    
    private UserService getService(String orderId){
        if (orderId.startsWith("07")){
            return userServiceImpl;
        }
        return userServicePackImpl;
    }

}
