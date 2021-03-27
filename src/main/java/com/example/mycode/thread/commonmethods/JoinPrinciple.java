package com.example.mycode.thread.commonmethods;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/2/23 12:26 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: join的代替写法
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });

        thread.start();
        System.out.println("开始等待子线程运行完毕");
//        thread.join();
        synchronized (thread) {
            thread.wait();
        }
        System.out.println("所有子线程执行完毕");
    }
}
