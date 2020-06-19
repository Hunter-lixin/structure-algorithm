package com.juc.alternateThread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * 使用线程交替打印1234567和ABCDEFG
 * 使用TransferQueue实现
 */
public class TransferQueueInTread {
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        TransferQueue<Character> transferQueen = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                for (char c : aI) {
                    System.out.print(transferQueen.take());
                    transferQueen.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : aC) {
                    transferQueen.transfer(c);
                    System.out.print(transferQueen.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

    }
}
