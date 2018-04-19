package com.zdp.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2015年4月1日 下午3:39:00
 */
public class Server {

    public static void main(String[] args) {
        try {
            PersonService personService = new PersonServiceImpl();
            // 注册通讯端口
            LocateRegistry.createRegistry(6600);
            // 注册通讯路径
            Naming.rebind("rmi://127.0.0.1:6600/PersonService", personService);
            System.out.println("Service Start!");
            System.out.println(System.currentTimeMillis());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
