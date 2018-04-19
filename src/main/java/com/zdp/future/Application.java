package com.zdp.future;

/**
 * Created by dapeng.zhou on 2016/9/30.
 */
public class Application {
    public static void main(String[] args) throws Exception{
        Data data = request();
        System.out.println(data.getResult());
    }

    public static Data request() {
        final FutureData futureData = new FutureData();
        new Thread(){
            public void run() {
                try {
                    Thread.sleep(3000);
                    futureData.setData(new RealData("hello"));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return futureData;
    }
}
