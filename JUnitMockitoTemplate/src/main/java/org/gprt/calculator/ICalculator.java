package org.gprt.calculator;

public interface ICalculator {
  int sumInt (int n1, int n2);
  int sumInts (int... ints);
  int divideInt (int divident, int quotient) throws Exception;
  double multiply(double... numbers);
}
