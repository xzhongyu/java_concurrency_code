package com.example.mycode.jmm;

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
 * @Date: create in 2021/2/3 12:37 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 指令重排
 */
public class ReSortDemo {
    static int a, b, c, d;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        long start = System.currentTimeMillis();
        for (; ; ) {
            i++;
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    b = c;
                }
            });
            t.start();

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    c = 1;
                    d = a;
                }
            });
            t2.start();
            t.join();
            t2.join();
            if ((a == 0 && b == 0) || (c == 0 && d == 0)) {
                long end = System.currentTimeMillis();
                System.out.println("出现了指令重排序，耗时：" + (end - start) + "创建线程数目：" + i);
                break;
            }
        }
    }
}
