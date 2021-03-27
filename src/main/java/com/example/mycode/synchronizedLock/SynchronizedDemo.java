package com.example.mycode.synchronizedLock;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/2/3 1:23 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: -XX:-UseBiasedLocking
 */
public class SynchronizedDemo {
    public static Integer j = 0;
    public  void demoMethod() {
        synchronized(this){
            j++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
//        SynchronizedDemo s = new SynchronizedDemo();
//        s.demoMethod();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch mainThread = new CountDownLatch(4000);
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        long begin = System.currentTimeMillis();
        for(int i =1;i<=4000;i++){
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
        System.out.println("消耗时长："+ (end-begin)+" ms");
    }
}
