package org.gprt.numsupplier;

public class NumSupplier implements INumSupplier {
    public int[] supplyInts(int n) {
        int[] ints = new int[n];
        for(int i = 0; i < n; i++) {
            ints[i] = (int) Math.round( Math.random()*10 );
        }
        return ints;
    }
}
