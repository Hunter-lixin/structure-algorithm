package com.LeetCode;

public class No_3259_maxEnergyBoost {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] d = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            d[i][0] = d[i - 1][0] + energyDrinkA[i - 1];
            d[i][1] = d[i - 1][1] + energyDrinkB[i - 1];
            if (i >= 2) {
                d[i][0] = Math.max(d[i][0], d[i - 2][1] + energyDrinkA[i - 1]);
                d[i][1] = Math.max(d[i][1], d[i - 2][0] + energyDrinkB[i - 1]);
            }
        }
        return Math.max(d[n][0], d[n][1]);
    }
}
