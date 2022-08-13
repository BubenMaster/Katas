package com.yojik.katas.solutions;

public class Prime {
    public static boolean isPrime(int num) {
        if (num == 2) return true;
        if (num > 2) {
//            float powDegree = (float) (Math.log(num) / Math.log(2));
//            int divider = (int) Math.round(Math.pow(2, (float) powDegree / 2));
          int divider = (int)Math.round(Math.sqrt(num));
            for (int i = 2; i <= (num / divider); i++) {
                if ((num % i) == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
