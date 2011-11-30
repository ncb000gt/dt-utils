package com.digitaltumbleweed.utils.collections;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class MultidimensionalList<C> {
    private ArrayList<LinkedList<C>> zero;

    public MultidimensionalList() {
        this(1);
    }

    public MultidimensionalList(int initialCapacity) {
        zero = new ArrayList<LinkedList<C>>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            zero.add(new LinkedList<C>());
        }
    }

    public void add(int x, C c) {
        LinkedList ll = zero.get(x);
        ll.add(c);
        zero.set(x, ll);
    }

    public void set(int x, int y, C c) {
        LinkedList ll = zero.get(x);
        ll.set(y, c);
        zero.set(x, ll);
    }

    public LinkedList remove(int x) {
        return zero.remove(x);
    }

    public C remove(int x, int y) {
        LinkedList<C> ll = zero.get(x);
        C c = ll.remove(y);
        zero.set(x, ll);

        return c;
    }

    public LinkedList get(int x) {
        return zero.get(x);
    }

    public C get(int x, int y) {
        return zero.get(x).get(y);
    }

    public int xSize() {
        return zero.size();
    }

    public int ySize(int x) {
        return zero.get(x).size();
    }

    @Override
    public String toString() {
        String s = "";
        //gross. iterator or something else would be better.
        boolean hasRow = true;
        int maxColSize = 0;
        int i = 0;
        while (hasRow) {
            
            final int zeroSize = zero.size();
            for (int j = 0; j < zeroSize; j++) {
                List<C> l = zero.get(j);
                if (l.size() > maxColSize) maxColSize = l.size();

                C val = l.get(i);
                s += val + ((j < (zeroSize - 1))?" ":"");
            }

            if (++i == maxColSize) {
                hasRow = false;
            } else {
                s += "\n";
            }
        }

        return s;
    }
}
