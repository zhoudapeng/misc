package com.zdp.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dapeng.zhou on 2016/10/9.
 */
public class Demo {
    public static void main(String[] args) {
        List<? extends Fruit> fruits = new ArrayList<Fruit>();
        //extends不能写，只能读，而且只能用Fruit或者Object读
        //fruits.add(new Apple());---会编译失败
        Fruit apple = fruits.get(0);
        List<? super Apple> apples = new ArrayList<Fruit>();
        // super可以写，但是读只能用Object去接
        apples.add(new Apple());

    }
}

class Fruit {}
class Apple extends Fruit{}
class Orange extends Fruit{}
