package com.example.mycode.jmm;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/2/3 4:12 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 饿汉模式例子DCL ，volatile禁止指令重排
 */
public class DoubleCheckLock {
    private volatile static DoubleCheckLock instance;
    private DoubleCheckLock(){}
    public static DoubleCheckLock getInstance(){
        //第一次检测
        if(instance==null){
            //同步
            synchronized(DoubleCheckLock.class){
                if(instance==null){
                    //多线程环境下可能会出现问题的地方
                    instance=new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
