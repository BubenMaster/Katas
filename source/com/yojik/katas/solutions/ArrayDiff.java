package com.yojik.katas.solutions;


import java.util.*;


public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {

        if (b.length > 0 && a.length > 0) {
            List<Integer> listOfA = new ArrayList<>(Arrays.stream(a).boxed().toList());
            for (int currentElement : a) {
                if (Arrays.stream(b).anyMatch(bElem -> bElem == currentElement)) {
                    listOfA.remove(Integer.valueOf(currentElement));
                }
            }
            a = new int[listOfA.size()];
            for (int i=0; i< a.length; i++) {
                a[i] = listOfA.get(i);
            }

        }
        return a;
    }
}
