package com.digitaltumbleweed.utils.collections;

import java.util.List;
import java.util.BitSet;
import java.util.HashSet;

public class ListUtils {
    public static int combineInts(List<Integer> list) {
        int combiner = 0;
        for (Integer i : list) {
            combiner += i;
        }

        return combiner;
    }

    public static <T> boolean isUnique(List<T> list) {
        if (list.size() > 0 && list.get(0) instanceof Integer) return ListUtils.isUniqueInteger((List<Integer> )list);

        HashSet<T> hs = new HashSet<T>();
        for (T t : list) {
            if (hs.contains(t)) return false;
            hs.add(t);
        }

        return true;
    }

    public static boolean isUniqueInteger(List<Integer> list) {
        BitSet bs = new BitSet(list.size());
        for (Integer i : list) {
            if (bs.get(i)) return false;
            bs.flip(i);
        }

        return true;
    }
}
