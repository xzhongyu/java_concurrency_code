package com.example.mycode.thread.uncaughtexception;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/15 9:58 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 单线程，抛出，处理，有异常堆栈 多线程，子线程发生异常，会有什么不同？
 */
public class ExceptionInChildThread implements Runnable {
    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
