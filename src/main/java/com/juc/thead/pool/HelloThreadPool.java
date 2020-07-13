package com.juc.thead.pool;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HelloThreadPool {
    static ThreadLocal<DateTimeFormatter> threadLocal =
            ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


    public static void main(String[] args) {

        CustomizeThreadPoolExecutor executor = new CustomizeThreadPoolExecutor();
        ThreadPoolExecutor threadPoolExecutor = executor.getThreadPoolExecutor();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " "
//                            + finalI + " " + threadPoolExecutor.getQueue().size()
                                    + " " + threadLocal.get().format(LocalDateTime.now())
//                            + " " + Thread.currentThread().getThreadGroup().getName()
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadPoolExecutor.shutdown();
    }
}
