package com.example.mycode.thread.stop;

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
 * @Date: create in 2021/1/12 12:45 上午
 * @Version: 1.0
 * @Slogan: 天下风云出我辈，一入代码岁月催
 * @Description: 注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 */
public class RightWayInterrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted: " + threadOne.interrupted());
        //获取中断标志并重直
        System.out.println("isInterrupted: " + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
