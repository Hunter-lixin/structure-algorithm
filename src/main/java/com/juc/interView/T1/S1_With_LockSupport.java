package com.juc.interView.T1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class S1_With_LockSupport {
    List<Object> list = new LinkedList<>();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    static Thread t1, t2;

    public static void main(String[] args) {
        S1_With_LockSupport withLockSupport = new S1_With_LockSupport();

        t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "结束");
            LockSupport.unpark(t1);
        }, "t2");

        t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            for (int i = 0; i < 10; i++) {
                withLockSupport.add(new Object());
                System.out.println(Thread.currentThread().getName() + " add " + i);

                if (withLockSupport.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }, "t1");

        t2.start();
        t1.start();
    }
}
