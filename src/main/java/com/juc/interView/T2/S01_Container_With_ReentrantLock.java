package com.juc.interView.T2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class S01_Container_With_ReentrantLock<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;

    private Lock lock = new ReentrantLock();
    Condition producerCondition = lock.newCondition();
    Condition consumerCondition = lock.newCondition();

    private int getCount() {
        try {
            lock.lock();
            return list.size();
        }finally {
            lock.unlock();
        }
    }

    private void put(T t) {
        try {
            lock.lock();
            while (getCount() == MAX) {
                producerCondition.await();
            }

            list.add(t);
            consumerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private T get() {
        try {
            lock.lock();
            while (getCount() == 0) {
                consumerCondition.await();
            }
            T t = list.removeFirst();
            producerCondition.signalAll();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        S01_Container_With_ReentrantLock<String> container = new S01_Container_With_ReentrantLock<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + " get :" + container.get());
                }
            }, "consumer" + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    container.put(Thread.currentThread().getName() + " put " + j);
                }
            }, "producer" + i).start();
        }
    }
}
