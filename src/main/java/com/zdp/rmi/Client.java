package com.zdp.rmi;

import java.rmi.Naming;
import java.util.List;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2015年4月1日 下午3:39:46
 */
public class Client {
    public static void main(String[] args) {
        try {
            //调用远程对象，注意RMI路径与接口必须与服务器配置一致
            PersonService personService = (PersonService) Naming.lookup("rmi://10.86.100.116:6600/PersonService");
            List<PersonEntity> personList = personService.GetList();
            for (PersonEntity person : personList) {
                System.out.println("ID:" + person.getId() + " Age:" + person.getAge() + " Name:" + person.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
