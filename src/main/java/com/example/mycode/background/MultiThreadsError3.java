package com.example.mycode.background;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xzhongyu
 * @Date: create in 2021/3/27 2:59 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 发布逸出
 */
public class MultiThreadsError3 {
    private Map<String, String> states;

    public MultiThreadsError3() {
        states = new HashMap<>();
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周四");
    }

    public Map<String, String> getStates() {
        return states;
    }

    public Map<String, String> getStatesImproved() {
        return new HashMap<>(states);
    }

    public static void main(String[] args) {
        MultiThreadsError3 multiThreadsError3 = new MultiThreadsError3();
        Map<String, String> states = multiThreadsError3.getStates();
//        System.out.println(states.get("1"));
//        states.remove("1");
//        System.out.println(states.get("1"));

        System.out.println(multiThreadsError3.getStatesImproved().get("1"));
        multiThreadsError3.getStatesImproved().remove("1");
        System.out.println(multiThreadsError3.getStatesImproved().get("1"));

    }
}
