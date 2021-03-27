package com.example.mycode.singleton;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/28 12:06 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 饿汉式（静态代码块）（可用）
 */
public class Singleton2 {
    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
