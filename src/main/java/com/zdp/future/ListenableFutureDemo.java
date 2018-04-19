package com.zdp.future;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

/**
 * Created by dapeng.zhou on 2016/10/10.
 */
public class ListenableFutureDemo {
    public static void main(String[] args) throws Exception{
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        ListenableFuture<String> future = listeningExecutorService.submit(new Callable<String>() {

            public String call() throws Exception {
                Thread.sleep(1000);
                throw new RuntimeException("我故意抛异常的,嘎嘎");
//                return "Hello,I am learning ListenableFuture";
            }
        });
        addListenerWithFutures(future);
        addListener(future);
    }

    private static void addListenerWithFutures(ListenableFuture<String> future) {
        Futures.addCallback(future, new FutureCallback<String>() {
            public void onSuccess(String result) {
                System.out.println("[Futures]execute success,result=" + result);
            }

            public void onFailure(Throwable t) {
                System.out.println("[Futures]execute fail");
                t.printStackTrace();
            }
        });
    }

    private static void addListener(final ListenableFuture<String> future) {
        future.addListener(new Runnable() {
            public void run() {
                try {
                    System.out.println("execute success,result=" + future.get());
                } catch (Exception e) {
                    System.out.println("execute fail");
                    e.printStackTrace();
                }
            }
        },Executors.newCachedThreadPool());
    }

}
