package com.yojik.katas.solutions;

import java.util.Arrays;
import java.util.Stack;

public class DirReduction {

    public static String[] dirReducFullWrong(String[] arr) {


        int digitNS = 0;
        int digitWE = 0;
        for (String s : arr) {
            digitWE = s.equals("WEST") || s.equals("EAST")
                    ? s.equals("WEST") ? digitWE + 1 : digitWE - 1
                    : digitWE;
            digitNS = s.equals("NORTH") || s.equals("SOUTH")
                    ? s.equals("NORTH") ? digitNS + 1 : digitNS - 1
                    : digitNS;
        }
        int totalSteps = Math.abs(digitNS) + Math.abs(digitWE);
        String[] simpleDirections = new String[totalSteps];
        for (int i = 0; i < Math.abs(digitWE); i++) {
            simpleDirections[i] = digitWE > 0 ? "WEST" : "EAST";
        }
        for (int i = Math.abs(digitWE); i < totalSteps; i++) {
            simpleDirections[i] = digitNS > 0 ? "NORTH" : "SOUTH";
        }

        return simpleDirections;
    }

    public static String[] dirReduc(String[] arr) {
        if (arr.length == 0) return arr;
        String[] simpleDirections = arr;
        for (int i = 1; i < arr.length; i++) {
          if (mutuallyNeutral(arr[i-1], arr[i])) {
              simpleDirections = dirReduc(i == 1
                                            ? Arrays.copyOfRange(arr, 2, arr.length)
                                            : i == arr.length-1
                                                ? Arrays.copyOfRange(arr, 0, arr.length-2)
                                                : takeOffTwoElementsFromTheMiddle(arr, i));
              break;
          }
        }

        return simpleDirections;
    }

    private static boolean mutuallyNeutral(String first, String second) {
        return  ( (first.equals("NORTH") && second.equals("SOUTH"))
                || (first.equals("SOUTH") && second.equals("NORTH")) )
                ||
                ( (first.equals("WEST") && second.equals("EAST"))
                || (first.equals("EAST") && second.equals("WEST")) );
    }

    public static String[] takeOffTwoElementsFromTheMiddle(String[] source, int higherElement) {
        String[] newArray = new String[source.length - 2];
        System.arraycopy(source, 0,newArray,0, higherElement - 1);
        System.arraycopy(source, higherElement + 1,newArray,higherElement - 1, source.length - higherElement -1);
        return newArray;
    }


}
