package com.zdp.math;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年8月10日 下午5:51:25
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(1-0.9);
        System.out.println(ceil(1 - 0.9));
        System.out.println(ceil(0));
    }
    
    private static double ceil(double d){
        int n = (int)(d *100);
        double result = Math.ceil(n / 10.0)/10.0;
        return result;
    }
}
