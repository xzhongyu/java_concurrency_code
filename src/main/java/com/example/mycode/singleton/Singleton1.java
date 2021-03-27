package com.example.mycode.singleton;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/27 11:25 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 饿汉式（静态常量）（可用）
 */
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
