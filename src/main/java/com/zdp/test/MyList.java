package com.zdp.test;

import java.util.ArrayList;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年1月19日 下午7:37:28
 */
public class MyList<T> extends ArrayList<T>{

    @Override
    public boolean add(T e) {
        if (null != e){
            return super.add(e);
        }
        return false;
    }
}
