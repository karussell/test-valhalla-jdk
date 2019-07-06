package com.graphhopper.valhallatest;

import java.util.Arrays;

public class PointList {
    private int size;
    private Point[] list;

    PointList(int cap) {
        list = new Point[cap];
    }

    public void add(Point point) {
        if (size == list.length)
            list = grow();
        list[size] = point;
        size++;
    }

    private Point[] grow() {
        return new Point[size * 3 / 2];
    }

    public int size() {
        return size;
    }

    int getCapacity() {
        return list.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
