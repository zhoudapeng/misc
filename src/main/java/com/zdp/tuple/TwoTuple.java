package com.zdp.tuple;

/**
 * Created by dapeng.zhou on 2017/2/8.
 */
public class TwoTuple<A,B> {
    private A a;
    private B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
