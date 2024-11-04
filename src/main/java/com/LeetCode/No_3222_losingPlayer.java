package com.LeetCode;

public class No_3222_losingPlayer {
    public String losingPlayer(int x, int y) {
        return Math.min(x, y / 4) % 2 == 0 ? "Bob" : "Alice";
    }

    public static void main(String[] args) {
        System.out.println(new No_3222_losingPlayer().losingPlayer(2, 7));
        System.out.println(new No_3222_losingPlayer().losingPlayer(4, 11));
    }
}
