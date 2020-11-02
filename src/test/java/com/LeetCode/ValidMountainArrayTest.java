package com.LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidMountainArrayTest {

    ValidMountainArray validMountainArray = new ValidMountainArray();

    @Test
    void validMountainArray_with_false_1() {
        int[] nums = new int[]{2, 1};
        assertFalse(validMountainArray.validMountainArray(nums));
    }

    @Test
    void validMountainArray_with_false_2() {
        int[] nums = new int[]{3, 5, 5};
        assertFalse(validMountainArray.validMountainArray(nums));
    }

    @Test
    void validMountainArray_with_true_3() {
        int[] nums = new int[]{0, 3, 2, 1};
        assertTrue(validMountainArray.validMountainArray(nums));
    }
}