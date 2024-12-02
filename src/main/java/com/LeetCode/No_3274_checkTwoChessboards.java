package com.LeetCode;

public class No_3274_checkTwoChessboards {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return (coordinate1.charAt(0) - coordinate2.charAt(0) + coordinate1.charAt(1) - coordinate2.charAt(1)) % 2 == 0;
    }
}
