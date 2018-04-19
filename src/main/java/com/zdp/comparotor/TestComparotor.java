package com.zdp.comparotor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date 2015年9月21日 下午4:50:52
 */
public class TestComparotor {
    public static void main(String[] args) {
//        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        List<Integer> simpleList = Arrays.asList(0,3,1,2,6,0);
        Comparator comparator = new SimpleComparator();
        Collections.sort(simpleList,comparator);
        System.out.println(simpleList);
        List<Integer> values = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 2, 30, 0,
                3);
        Collections.sort(values,comparator);
        System.out.println(values);
    }
}

class SimpleComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? 1 : -1;
    }
}
