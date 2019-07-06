package com.graphhopper.valhallatest;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PointListTest {

    @Test
    public void add() {
        // the last passing max value with "-Xmx10m -Xms10m" (see pom.xml)
        int MAX = 450_000; // JDK 14 with valhalla and "public inline class Point"
//         int MAX = 240_000; // JDK 14 with valhalla without inline
//         int MAX = 200_000; // JDK 12
        PointList list = new PointList(MAX);
        for (int i = 0; i < MAX; i++) {
            list.add(42.0, 11 + (1.0 + i) / i);
        }

        assertEquals(MAX, list.size());
    }
}