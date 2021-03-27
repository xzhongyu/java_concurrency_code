package com.example.mycode.thread.commonmethods;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/2/23 12:30 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 先join再mainThread.getState() 通过debugger看线程join前后状态的对比
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(mainThread.getState());
                System.out.println("Thread-0运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println(mainThread.getState());
        System.out.println("等待子线程运行完毕");

        thread.join();

        System.out.println(mainThread.getState());
        System.out.println("子线程运行完毕");

    }
}
