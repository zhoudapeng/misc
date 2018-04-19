package com.zdp.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2015年4月1日 下午3:24:58
 */

//此为远程对象调用的接口，必须继承Remote类
public interface PersonService extends Remote {
    public List<PersonEntity> GetList() throws RemoteException;
}
