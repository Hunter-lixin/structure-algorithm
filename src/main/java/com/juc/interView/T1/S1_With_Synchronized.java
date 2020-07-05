package com.juc.interView.T1;

import java.util.LinkedList;
import java.util.List;

public class S1_With_Synchronized {
    List<Object> list = new LinkedList<>();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        S1_With_Synchronized withSynchronized = new S1_With_Synchronized();
        Object lock = new Object();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束");
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    withSynchronized.add(new Object());
                    System.out.println(Thread.currentThread().getName() + " add " + i);

                    if (withSynchronized.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }, "t1").start();
    }
}
