package com.LeetCode;

import java.util.List;

public class No_3248_finalPositionOfSnake {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int ans = 0;
        for (String c : commands) {
            if (c.charAt(0) == 'U') {
                ans -= n;
            } else if (c.charAt(0) == 'D') {
                ans += n;
            } else if (c.charAt(0) == 'L') {
                --ans;
            } else {
                ++ans;
            }
        }
        return ans;
    }
}
