package com.zdp.pattern.design.service;

import org.springframework.stereotype.Service;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年2月5日 下午5:13:15
 */
@Service("userServicePackImpl")
public class UserServicePackImpl extends AbstractUserService {

    public boolean book(BookCommand command) {
        return false;
    }

}
