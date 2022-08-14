package com.yojik.katas.solutions;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BalancedParens {

        public static List<String> balancedParens (int n) {

            int doubledN = n*2;
            List<String> goodParens = new ArrayList<>();

            for (int i=0; i<Math.round(Math.pow(2, doubledN)); i++) {

                Integer ord = i;
                BitSet bits = BitSet.valueOf(new long[]{ord.longValue()});

                if (bitsDisturbedNotEqually(doubledN, bits)) continue;

                StringBuilder rawParentheses = new StringBuilder(doubledN);

                if ((ordersIsRight(doubledN, bits, rawParentheses))) goodParens.add(rawParentheses.toString());
            }
            return goodParens;
        }

    private static boolean ordersIsRight(int doubledN, BitSet bits, StringBuilder rawParentheses) {
//         Checking order by getting sum of sequence 1 and -1, meaning opening and closing parentheses.
//         If at any position sum < 0 we get closing parentheses before opening that not fit in right order.
            int sum = 0;
        for (int reverseBitIndex = doubledN -1; reverseBitIndex>=0; reverseBitIndex--) {
            sum += bits.get(reverseBitIndex) ? 1 : (-1) ;
            if (sum < 0) break;
            rawParentheses.append(bits.get(reverseBitIndex) ? "(" : ")");
        }
        return sum >= 0;
    }

    private static boolean bitsDisturbedNotEqually(int doubledN, BitSet bits) {
        return bits.length() < doubledN || bits.length() - 2 * bits.cardinality() != 0;
    }
}
