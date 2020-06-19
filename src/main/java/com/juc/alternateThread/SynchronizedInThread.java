package com.juc.alternateThread;

/**
 * 使用线程交替打印1234567和ABCDEFG
 * 使用synchronized实现
 */
public class SynchronizedInThread {
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        Object o = new Object();

        new Thread(() -> {
            try {
                synchronized (o) {
                    for (char c : aC) {
                        System.out.print(c);
                        o.notify();
                        o.wait();
                    }
                    o.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                synchronized (o) {
                    for (char c : aI) {
                        System.out.print(c);
                        o.notify();
                        o.wait();
                    }
                    o.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

    }
}
