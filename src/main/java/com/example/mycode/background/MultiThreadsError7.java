package com.example.mycode.background;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/27 10:42 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 用工厂模式修复刚才的初始化问题
 */
public class MultiThreadsError7 {
    private static Map<String, String> states;

    private MultiThreadsError7(Thread thread) {
        thread.start();
    }

    public Map<String, String> getStates() {
        return states;
    }

    @SneakyThrows
    public static MultiThreadsError7 getInstance() {
        Thread thread = new Thread(() -> {
            states = new HashMap<>();
            states.put("1", "周一");
            states.put("2", "周二");
            states.put("3", "周三");
            states.put("4", "周四");
        });
        MultiThreadsError7 safeListener = new MultiThreadsError7(thread);
        thread.join();
        return safeListener;
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadsError7 multiThreadsError7 = MultiThreadsError7.getInstance();
        System.out.println(multiThreadsError7.getStates().get("1"));
    }
}
