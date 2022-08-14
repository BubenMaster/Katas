package com.yojik.katas.sandboxes;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SandboxForBalancedParens {
    public static void main(String[] args) {
        int n = 5;
        int doubledN = n*2;
        List<String> goodParens = new ArrayList<>();
        for (int i=0; i<Math.round(Math.pow(2, doubledN)); i++) {
            Integer ord = Integer.valueOf(i);
            BitSet bits = BitSet.valueOf(new long[]{ord.longValue()});
//           1. проверка на количество и симметричность элементов:
            if (bits.length() < doubledN || bits.length() - 2*bits.cardinality() != 0) continue;
//            ****************************************************
//            2. проверка на правильную последовательность элементов:
            StringBuilder rawParentheses = new StringBuilder(doubledN);
            int sum = 0;
            for (int bitIndex=doubledN-1; bitIndex>=0; bitIndex--) {
                sum += bits.get(bitIndex) ? 1 : (-1) ;
                if (sum < 0) break;
                rawParentheses.append(bits.get(bitIndex) ? "(" : ")");
//                System.out.print(parenthesis);
            }
//            ****************************************************
            if (! (sum < 0))goodParens.add(rawParentheses.toString());
            System.out.println(bits + " and size: " + bits.length());
        }

        System.out.println(goodParens);
    }
}