package com.juc.thead.pool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CancelSubProdThreadPool {

    /*public CancelSubProdThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), r -> null, new ThreadPoolExecutor.DiscardOldestPolicy());

    }*/

    public static class NamedThreadFactory implements ThreadFactory {

        private final AtomicInteger poolNumber = new AtomicInteger(1);

        private final ThreadGroup threadGroup;

        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public  final String namePrefix;

        NamedThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            threadGroup = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            if (null == name || "".equals(name.trim())) {
                name = "pool";
            }
            namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(threadGroup, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

    public static class NamedRejectedExecutionHandle implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static ThreadLocal<DateTimeFormatter> threadLocal =
            ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 2,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new NamedThreadFactory("测试"),new NamedRejectedExecutionHandle());

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(threadPoolExecutor.getQueue().size());
//                    System.out.println(Thread.currentThread().getName());
                    if (threadPoolExecutor.getQueue().size() % 10 == 2) {
                        throw new RuntimeException("异常验证");
                    }
                    System.out.println(threadPoolExecutor.getActiveCount());
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(threadLocal.get().format(LocalDateTime.now()) + "    " + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadPoolExecutor.shutdown();

    }
}
