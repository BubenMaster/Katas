package com.yojik.katas.tests;


import com.yojik.katas.solutions.AreSame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AreSameTest {

    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertTrue(AreSame.comp(a, b));
        a = new int[]{121, 144, 20, 161, 19, 144, 19, 11};
        b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertFalse(AreSame.comp(a, b));
        a = new int[0];
        b = new int[0];
        assertFalse(AreSame.comp(a, b));
    }
}