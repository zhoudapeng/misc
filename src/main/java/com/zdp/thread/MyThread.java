package com.zdp.thread;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2015年2月27日 下午6:46:48
 */
public class MyThread implements Runnable {

    public void run() {
        double d = 0;
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < 900000; i++) {
                    d = d + (Math.PI + Math.E) / d;
                }
                System.out.println("start sleep...");
                Thread.sleep(200);
//                int n = 0;
//                for (int i = 0; i < 100; i++) {
//                    System.out.println("interrupted=" + Thread.interrupted());
//                }
                // while(true){
                // System.out.println("haha");
                // n++;
                // System.out.println("n="+n);
                // if (n >=200){
                // System.out.println("interrupted="+Thread.interrupted());
                // if (Thread.interrupted()){
                // System.out.println("n has reached 200");
                // }
                // }
                // }
            }
            System.out.println("The Thread was interrupted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new MyThread());
        thread.start();
        Thread.sleep(300);
        System.out.println("interrupt...");
        thread.interrupt();
    }

}
