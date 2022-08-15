package com.yojik.katas.solutions;

import java.util.ArrayList;

import java.util.List;

public class Hamming {

    public static long hamming(int n) {
        List<Long> hammingNumbers =new ArrayList<>();

        List<Integer> multiplyIndexes = new ArrayList<>();
        for(int i =0; i <3; i++) multiplyIndexes.add(0);
        List<Long> localResults = new ArrayList<>();
        for(int i =0; i <3; i++) localResults.add(1L);

        for (int index = 1; index <= n; index ++){
            if (index == 1) {
                hammingNumbers.add(1L);
            }
            else {
                for (int multiplyIndex = 0; multiplyIndex < 3; multiplyIndex++) {
                    localResults.set(multiplyIndex, hammingNumbers.get(multiplyIndexes.get(multiplyIndex))
                            * (multiplyIndex == 0 ? 2 : multiplyIndex == 1 ? 3 : 5));
                }
                Long nextHamming = localResults.get(0) < localResults.get(1)
                        ?
                        localResults.get(0) < localResults.get(2) ? localResults.get(0) : localResults.get(2)
                        :
                        localResults.get(1) < localResults.get(2) ? localResults.get(1) : localResults.get(2);

                int incrementingMultiplyIndex = localResults.indexOf(nextHamming);
                multiplyIndexes.set(incrementingMultiplyIndex, multiplyIndexes.get(incrementingMultiplyIndex) + 1);

                if (hammingNumbers.contains(nextHamming)) {
                    index--;
                }
                else {
                    hammingNumbers.add(nextHamming);
                }
            }
        }
        return hammingNumbers.get(n-1);
    }

    public static long hammingBestPractice(int n) {
        long[] h = new long[n];
        h[0] = 1;
        long x2 = 2, x3 = 3, x5 = 5;
        int i = 0, j = 0, k = 0;

        for (int index = 1; index < n; index++) {
            h[index] = Math.min(x2, Math.min(x3, x5));
            if (h[index] == x2) x2 = 2 * h[++i];
            if (h[index] == x3) x3 = 3 * h[++j];
            if (h[index] == x5) x5 = 5 * h[++k];
        }

        return h[n - 1];
    }
}