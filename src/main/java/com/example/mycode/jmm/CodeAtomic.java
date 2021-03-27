package com.example.mycode.jmm;

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
 * @Date: create in 2020/12/29 1:48 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: volatile无法保证原子性
 */
public class CodeAtomic implements Runnable {
    private volatile static int counter = 0;
//    static Object object = new Object();

    public static void main(String[] args) {

        Runnable target = new CodeAtomic();

        for (int i = 0; i < 10; i++) {
            new Thread(target, "thread"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);

    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            counter++;//分三步- 读，自加，写回
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕！");
    }
}
