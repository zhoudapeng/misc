package com.zdp.multithread;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2014年12月26日 上午9:46:56
 */
public class DaemonDemo {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            Thread thread = new Thread(new DThread(i));
            thread.setDaemon(true);
            thread.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DThread implements Runnable{
    
    
    private int index;
    
    public DThread(int index){
        this.index = index;
    }

    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am Daemon Thread["+index+"]");
        }
    }
}
