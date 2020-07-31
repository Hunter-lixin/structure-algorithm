package com.juc.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureThread {

    public static void main(String[] args) {
        FutureThread t = new FutureThread();
        List<Future<String>> futureList = new ArrayList<>();
        t.generate(3, futureList);
        List<String> resultList = t.getResultList(futureList);
        for (String s : resultList) {
            System.out.println(s);
        }
    }

    public List<String> getResultList(List<Future<String>> fList) {
        List<String> result = new ArrayList<>();
        for (Future<String> future : fList) {
            try {
                while (true) {
                    if (future.isDone() && !future.isCancelled()) {
                        result.add(future.get());
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 生成指定数量的线程，都放入future数组
     */
    public void generate(int threadNum, List<Future<String>> fList) {
        ExecutorService service = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            Future<String> f = service.submit(doBusiness(i));
            fList.add(f);
        }
        service.shutdown();
    }

    /**
     * 生成指定序号的线程对象
     */
    public Callable<String> doBusiness(final int i) {
        return () -> "thread - " + i;
    }

}
