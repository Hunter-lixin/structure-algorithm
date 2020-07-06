package com.juc.interView.T2;

import java.util.LinkedList;

public class S02_Container_With_Synchronized<T> {
    final LinkedList<T> list = new LinkedList<>();

    final int MAX = 10;

    public synchronized int getCount() {
        return list.size();
    }

    public synchronized void put(T t) {
        while (getCount() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(t);
        this.notifyAll();
    }

    public synchronized T get() {
        while (getCount() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T t = list.removeFirst();
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        S02_Container_With_Synchronized<String> container = new S02_Container_With_Synchronized<>();

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
