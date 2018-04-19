package com.zdp.classloader;

import com.zdp.cache.Cache;
import com.zdp.cache.Demo;

import java.net.URLEncoder;

/**
 * Created by dapeng.zhou on 2017/5/24.
 */
public class MyClassLoader extends ClassLoader {
    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public static void main(String[] args) throws Exception{
        System.out.println(URLEncoder.encode("https://car.qunar.com/h5/activity/dragonholiday/index.html?hybridid=mob_hcar&nfrom=776","utf-8"));
//        ClassLoader parent = MyClassLoader.class.getClassLoader().getParent();
//        MyClassLoader classLoader = new MyClassLoader(parent);
////        Thread.currentThread().setContextClassLoader(classLoader);
//        System.out.println(Thread.currentThread() + "上下文类加载器="+Thread.currentThread().getContextClassLoader());
////        System.out.println(parent);
////        System.out.println(Demo.class.getClassLoader());
//        new Thread(){
//            public void run() {
////                System.out.println("thread1="+this);
//                System.out.println("loader1"+this.getClass().getClassLoader());
//                System.out.println(Thread.currentThread() + "上下文类加载器="+Thread.currentThread().getContextClassLoader());
//                Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader().getParent());
//                new Thread(){
//                    public void run() {
////                        System.out.println("thread2="+this);
//                        System.out.println(Thread.currentThread() + "上下文类加载器="+Thread.currentThread().getContextClassLoader());
//                        System.out.println("loader2="+this.getClass().getClassLoader());
//                        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader().getParent());
//                    }
//                }.start();
//            }
//        }.start();
    }
}
