package com.example.mycode.jmm;

/**
 * @Author: xzhongyu
 * @Date: create in 2020/12/29 2:49 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 看看new对象的字节码分几步  java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly O.class
 */
public class O {
    public void newStep() {
        new Object();
    }
}
