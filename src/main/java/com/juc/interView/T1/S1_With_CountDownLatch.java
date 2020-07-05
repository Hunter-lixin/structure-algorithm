package com.juc.interView.T1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class S1_With_CountDownLatch {
    List<Object> list = new LinkedList<>();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        S1_With_CountDownLatch withCountDownLatch = new S1_With_CountDownLatch();
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
            countDownLatch2.countDown();
        }, "t2").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            for (int i = 0; i < 10; i++) {
                withCountDownLatch.add(new Object());
                System.out.println(Thread.currentThread().getName() + " add " + i);

                if (withCountDownLatch.size() == 5) {
                    countDownLatch1.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }, "t1").start();

    }
}
