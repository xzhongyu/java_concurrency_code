package com.example.mycode.background;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/15 10:19 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 创建100个线程，用活动监视器的CPU栏目看Java线程数量的变化，10秒后线程消失了。
 */
public class Create100Threads {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
