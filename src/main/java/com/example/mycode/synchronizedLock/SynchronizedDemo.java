package com.example.mycode.synchronizedLock;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/2/3 1:23 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: -XX:-UseBiasedLocking 关闭偏向锁
 */
public class SynchronizedDemo {
    public static Integer j = 0;
    private final static CountDownLatch countDownLatch = new CountDownLatch(1);
    private final static CountDownLatch mainThread = new CountDownLatch(4000);

    public void demoMethod() {
        synchronized (this) {
            j++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        long begin = System.currentTimeMillis();
        long count = mainThread.getCount();
        for (int i = 1; i <= count; i++) {
            System.out.println(i);
            Thread t = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    countDownLatch.await();
                    synchronizedDemo.demoMethod();
                    mainThread.countDown();
                }
            });
            t.start();
        }
        countDownLatch.countDown();
        mainThread.await();
        long end = System.currentTimeMillis();
        System.out.println("消耗时长：" + (end - begin) + " ms");
    }
}
