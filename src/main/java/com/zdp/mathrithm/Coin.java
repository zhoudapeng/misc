package com.zdp.mathrithm;

/**
 * 给你100块钱，还有1元，2元，5元的硬币，求出能有多少种组合凑成100块钱
 * 
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2015年5月7日 下午5:16:09
 */
public class Coin {
    public static void main(String[] args) {
        System.out.println(count(3,4));
    }

    private static int count(int maxAddEnd, int sum) {
        if(sum == 1 || maxAddEnd == 1){
            return 1;
        }
        // 加数有maxAddEnd
        System.out.println("count("+maxAddEnd+","+sum+")=count("+(maxAddEnd-1)+","+(sum-maxAddEnd)+")+"+"count("+(maxAddEnd-1)+","+sum+")");
        return count(maxAddEnd, sum - maxAddEnd) + count(maxAddEnd - 1, sum);
    }
}
