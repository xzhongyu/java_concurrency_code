package com.example.mycode.thread.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/15 10:00 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: MyUncaughtExceptionHanlder
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常，终止啦" + t.getName());
        System.out.println(name + "捕获了异常" + t.getName() + "异常");
    }
}
