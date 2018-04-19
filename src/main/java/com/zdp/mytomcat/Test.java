package com.zdp.mytomcat;

import java.io.File;

/**
 * Created by dapeng.zhou on 2016/2/19.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("/abc/d".replace("/", File.separator));
    }
}
