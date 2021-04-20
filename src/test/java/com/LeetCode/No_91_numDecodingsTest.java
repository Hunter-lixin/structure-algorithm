package com.LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class No_91_numDecodingsTest {

    No_91_numDecodings solution = new No_91_numDecodings();

    @Test
    public void should_return_2_given_12() {
        String s = "12";
        assertEquals(2, solution.numDecodings(s));
    }

    @Test
    public void should_return_3_given_226() {
        String s = "226";
        assertEquals(3, solution.numDecodings(s));
    }

    @Test
    public void should_return_0_given_0() {
        String s = "0";
        assertEquals(0, solution.numDecodings(s));
    }

    @Test
    public void should_return_0_given_06() {
        String s = "06";
        assertEquals(0, solution.numDecodings(s));
    }

    @Test
    public void should_return_1_given_27() {
        String s = "27";
        assertEquals(1, solution.numDecodings(s));
    }

}