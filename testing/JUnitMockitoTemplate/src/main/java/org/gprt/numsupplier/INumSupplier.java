package org.gprt.numsupplier;

import java.util.List;

public interface INumSupplier {
  int[] supplyInts(int num);
  Float supplyAnyFloat();
  int supplyAnyInt();
  int[] toIncrementedIntArray(List<Integer> list);
}
