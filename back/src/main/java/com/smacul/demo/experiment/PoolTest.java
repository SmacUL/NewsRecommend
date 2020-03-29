package com.smacul.demo.Experiment;

import java.lang.reflect.Method;

/**
 * 推荐池实验
 */
public class PoolTest {

    private static PoolTest instance;
    private static Integer[] a;

    private PoolTest() {

    }

    public static PoolTest getPollTest() {
        if (instance == null) {
            instance = new PoolTest();
            a = new Integer[]{1, 2, 3, 4};
            System.out.println("实例创建");
        }
        System.out.println("实例返回");
        return instance;
    }

    public void printA() {
        for (Integer i: a) {
            System.out.println(i);
        }
        System.out.println("------");
    }

    public void setA(Integer index, Integer num) {
        a[index] = num;
    }

}
