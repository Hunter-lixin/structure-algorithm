package com.juc.thead.pool;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomizeThreadPoolExecutor {
    private volatile ThreadPoolExecutor executor = null;

    public void init() {
        executor = new ThreadPoolExecutor(6, 10, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20), new CustomizeThreadFactory(""), new CustomizeRejectedExecutionHandle());
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        if (executor == null) {
            synchronized (this) {
                if (executor == null) {
                    init();
                }
            }
        }
        return executor;
    }

    /**
     * 自定义线程工厂
     */
    public static class CustomizeThreadFactory implements ThreadFactory {

        private final AtomicInteger poolNumber = new AtomicInteger(1);

        private final ThreadGroup threadGroup;

        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public  final String namePrefix;

        CustomizeThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            threadGroup = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            if (null == name || "".equals(name.trim())) {
                name = "pool";
            }

            InetAddress addr;
            String ip = null;
            String hostName = null;
            try {
                addr = InetAddress.getLocalHost();
                ip = addr.getHostAddress(); //获取本机ip
                hostName = addr.getHostName();//获取本机计算机名称
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            name = name + "-" + ip + "-" + hostName;
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

    /**
     * 自定义拒绝策略
     */
    public static class CustomizeRejectedExecutionHandle implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
