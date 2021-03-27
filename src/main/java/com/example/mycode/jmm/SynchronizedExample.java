package com.example.mycode.jmm;

import lombok.SneakyThrows;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 程序出Bug了？
 * 　　　∩∩
 * 　　（´･ω･）
 * 　 ＿|　⊃／(＿＿_
 * 　／ └-(＿＿＿／
 * 　￣￣￣￣￣￣￣
 * 算了反正不是我写的
 * 　　 ⊂⌒／ヽ-、＿
 * 　／⊂_/＿＿＿＿ ／
 * 　￣￣￣￣￣￣￣
 * 万一是我写的呢
 * 　　　∩∩
 * 　　（´･ω･）
 * 　 ＿|　⊃／(＿＿_
 * 　／ └-(＿＿＿／
 * 　￣￣￣￣￣￣￣
 * 算了反正改了一个又出三个
 * 　　 ⊂⌒／ヽ-、＿
 * 　／⊂_/＿＿＿＿ ／
 * 　￣￣￣￣￣￣￣
 *
 * @Author: xzhongyu
 * @Date: create in 2020/12/27 4:18 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 顺序一致性
 */
public class SynchronizedExample {

    int a = 0;
    boolean flag = false;

    @SneakyThrows
    public synchronized void writer() { //获取锁
        TimeUnit.SECONDS.sleep(3);
        a = 1;
        flag = true;
    } //释放锁

    public synchronized void reader() { //获取锁
        if (flag) {
            //……
            System.out.println("a : " + a);
        } //释放锁
    }

    public static void main(String[] args) {
        SynchronizedExample synchronizedExample = new SynchronizedExample();

        new Thread(synchronizedExample::writer).start();
        new Thread(synchronizedExample::reader).start();

    }

}
