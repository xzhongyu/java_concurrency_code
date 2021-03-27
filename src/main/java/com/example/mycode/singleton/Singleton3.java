package com.example.mycode.singleton;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/28 12:12 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 懒汉式（线程不安全）
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
