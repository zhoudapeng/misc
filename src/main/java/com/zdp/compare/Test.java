package com.zdp.compare;

/**
 * Created by dapeng.zhou on 2016/1/25.
 */
public class Test {
    public static void main(String[] args) {
        Double a = 1d;
        Double b = 1d;
        System.out.println(a == b);
    }


}

class A {
    Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
