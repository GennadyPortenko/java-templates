package org.gprt.numsupplier;

import java.util.List;

public class NumSupplier implements INumSupplier {
    @Override
    public int[] supplyInts(int n) {
        int[] ints = new int[n];
        for(int i = 0; i < n; i++) {
            ints[i] = (int) Math.round( Math.random()*10 );
        }
        return ints;
    }
    @Override
    public Float supplyAnyFloat() {
        return 0f;
    }
    @Override
    public int supplyAnyInt() {
        return 0;
    }
    @Override
    public int[] toIncrementedIntArray(List<Integer> list) {
        return list.stream().mapToInt(elem -> elem + 1).toArray();
    }
}
