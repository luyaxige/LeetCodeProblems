package com.luyaxige.solution;

import org.omg.CORBA.FREE_MEM;

public class Graph {

    public boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y) return false;
        if (z == x || z == y || x + y == z) return true;
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public void checkCanMeasureWater() {
        System.out.println(canMeasureWater(3, 5, 4));
        System.out.println(canMeasureWater(2, 6, 5));
    }
}
