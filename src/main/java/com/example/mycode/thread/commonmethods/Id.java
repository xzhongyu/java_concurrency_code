package com.example.mycode.thread.commonmethods;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/2/22 8:44 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: ID从1开始，JVM运行起来后，我们自己创建的线程的ID早已不是2
 */
public class Id {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的ID: "+Thread.currentThread().getId());
        System.out.println("子线程的ID: "+thread.getId());
    }
}
