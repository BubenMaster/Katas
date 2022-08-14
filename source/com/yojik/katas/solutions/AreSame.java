package com.yojik.katas.solutions;

import javax.lang.model.util.Elements;
import java.util.*;
import java.util.stream.Collectors;

public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length == 0 || b.length == 0) return false;
        List<Integer> listA =  Arrays.stream(a).boxed().toList();
        List<Integer> listB = Arrays.stream(b).boxed().toList();
        List<Integer> copyOfListB = new ArrayList<>(listB.size() + 1);
        copyOfListB.addAll(listB);
        for (Integer numA: listA) {
            Integer numB = numA*numA;
            if (!copyOfListB.remove(numB)) return false;

        }
        return true;
    }
}
