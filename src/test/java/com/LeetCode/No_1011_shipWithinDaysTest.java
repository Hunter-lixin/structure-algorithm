package com.LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class No_1011_shipWithinDaysTest {

    No_1011_shipWithinDays solution = new No_1011_shipWithinDays();

    @Test
    public void should_return_15_given_5() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        assertEquals(15, solution.shipWithinDays(weights,days));
    }

    @Test
    public void should_return_6_given_3() {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;
        assertEquals(6, solution.shipWithinDays(weights,days));
    }

}