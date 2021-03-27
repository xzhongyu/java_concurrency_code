package com.example.mycode.jmm;

import com.example.mycode.jmm.util.UnsafeInstance;
import sun.misc.Unsafe;

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
 * @Date: create in 2020/12/26 6:44 下午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 指令重排
 */
public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0, n = 0;

    public static void main(String[] args) throws InterruptedException {
        Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
        while (true) {
            Thread one = new Thread(() -> {
                a = 1;
                unsafe.fullFence();
                x = b;
            });

            Thread other = new Thread(() -> {
                b = 1;
                unsafe.fullFence();
                y = a;
            });

            one.start();
            other.start();
            one.join();
            other.join();

            if (x == y) {
                System.out.println("出现指令重排,执行次数" + n);
                System.out.println("(" + x + "," + y + ")");
                break;
            } else {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
                n++;
            }
        }
    }
}
