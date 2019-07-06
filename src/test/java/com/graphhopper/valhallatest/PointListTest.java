package com.graphhopper.valhallatest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PointListTest {

    @Test
    public void add() {
        // the last passing max value with "-Xmx500m -Xms500m" (see pom.xml)
        int MAX = 32_500_000; // JDK 14 with valhalla and "public inline class Point"
//       int MAX = 14_000_000; // JDK 14 with valhalla without inline
        PointList list = new PointList(MAX);
        for (int i = 0; i < MAX; i++) {
            list.add(new Point(42.0, 11 + (1.0 + i) / i));
        }

        assertEquals(MAX, list.size());
    }

    @Test
    public void addAsReference() {
        int MAX = 14_000_000; // with inline
        List<Point?> list = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            list.add(new Point(42.0, 11 + (1.0 + i) / i));
        }

        assertEquals(MAX, list.size());
    }
}