package com.example.mycode.thread.commonmethods;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/2/23 12:21 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: join期间被中断
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(() -> {
            try {
                mainThread.interrupt();
                Thread.sleep(5000);
                System.out.println("Thread1 finished.");
            } catch (InterruptedException e) {
                System.out.println("子线程中断");
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"主线程中断了");
            thread1.interrupt();
        }
        System.out.println("子线程已运行完毕");
    }
}
