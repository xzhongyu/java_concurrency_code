package com.example.mycode.background;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/27 10:40 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 构造函数中新建线程
 */
public class MultiThreadsError6 {
    private Map<String, String> states;

    public MultiThreadsError6() {
        new Thread(() -> {
            states = new HashMap<>();
            states.put("1", "周一");
            states.put("2", "周二");
            states.put("3", "周三");
            states.put("4", "周四");
        }).start();
    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadsError6 multiThreadsError6 = new MultiThreadsError6();
//        TimeUnit.SECONDS.sleep(1);
        System.out.println(multiThreadsError6.getStates().get("1"));
    }
}
