package com.digitaltumbleweed.utils.collections;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

//More of a table...api change later?
//at the expense of memory for runtime, we duplicate the data and manage the duplication
//I'm ok with this tradeoff
public class MultidimensionalList<C> {
    private ArrayList<ArrayList<C>> cols;
    private ArrayList<ArrayList<C>> rows;
    private int rowCount = 0;
    private int colCount = 0;

    public MultidimensionalList() {
        this(1, 1);
    }

    public MultidimensionalList(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;

        rows = new ArrayList<ArrayList<C>>(rowCount);
        cols = new ArrayList<ArrayList<C>>(colCount);

        for (int i = 0; i < rowCount; i++) {
            ArrayList<C> colList = new ArrayList<C>(colCount);
            for (int j = colCount; j > 0; j--)
                colList.add(null);
            rows.add(colList);
        }

        for (int l = 0; l < colCount; l++) {
            ArrayList<C> rowList = new ArrayList<C>(rowCount);
            for (int k = rowCount; k > 0; k--)
                rowList.add(null);
            cols.add(rowList);
        }
    }

    public void set(int x, int y, C c) {
        setRow(x, y, c);
        setCol(x, y, c);
    }

    //this isn't safe, if either x or y aren't set it will blow up.
    private void setRow(int x, int y, C c) {
        ArrayList<C> list = rows.get(x);
        list.set(y, c);
        rows.set(x, list);
    }

    //this isn't safe, if either x or y aren't set it will blow up.
    private void setCol(int x, int y, C c) {
        ArrayList<C> list = cols.get(y);
        list.set(x, c);
        cols.set(y, list);
    }

    public List<C> getRow(int y) {
        return rows.get(y);
    }

    public List<C> getCol(int x) {
        return cols.get(x);
    }

    public C get(int x, int y) {
        return rows.get(x).get(y);
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    @Override
    public String toString() {
        String s = "";
        int i = 0;
        for (List<C> row : rows) {
            int j = 0;
            for (C val : row) {
                s += val + ((j++ < (colCount - 1))?" ":"");
            }
            s += ((i++ < (rowCount - 1))?"\n":"");
        }

        return s;
    }
}
