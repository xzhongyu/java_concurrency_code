package com.example.mycode.thread.uncaughtexception;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/15 10:02 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description:
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));

        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(1000);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(1000);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
        Thread.sleep(1000);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-4").start();
    }


    @Override
    public void run() {
        throw new RuntimeException();
    }
}
