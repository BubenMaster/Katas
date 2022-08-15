package com.yojik.katas.sandboxes;

import com.yojik.katas.solutions.Hamming;

public class SandboxForHammingFaster {

    public static void main(String[] args) {
        int n = 50;
        for (int i = 1; i<=n; i ++) {
            System.out.println("Hamming number with index " + i + ": " +Hamming.hamming(i));
        }


    }
}
