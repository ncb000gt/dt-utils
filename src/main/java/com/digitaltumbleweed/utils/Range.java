package com.digitaltumbleweed.utils;

public class Range {
    public static int[] range(int to) {
        return Range.range(0, to);
    }

    public static int[] range(int from, int to) {
        return Range.range(from, to, 1);
    }

    public static int[] range(int from, int to, int step) {
        double d = (double)(to-from)/(double)step;
        int size = (int) Math.ceil(d);

        int[] range = new int[size];
        for (int i = from; i < to; i += step) {
            range[(i-from)/step] = i;
        }

        return range;
    }
}
