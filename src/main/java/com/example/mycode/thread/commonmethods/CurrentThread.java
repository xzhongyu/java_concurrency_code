package com.example.mycode.thread.commonmethods;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/2/22 8:42 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 演示打印main, Thread-0, Thread-1
 */
public class CurrentThread implements Runnable{

    public static void main(String[] args) {
        new CurrentThread().run();
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
