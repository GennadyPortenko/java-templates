package org.gprt.calculator;

public class Calculator implements ICalculator {
  @Override
  public int sumInt (int n1, int n2) {
    return n1 + n2;
  }
  @Override
  public int divideInt (int divident, int quotient) throws Exception {
    return divident / quotient;
  }
  @Override
  public double multiply(double... numbers) {
    double result = 1;
    for ( int i = 0; i < numbers.length; i++ ) {
      result *= numbers[i];
    }
    return result;
  }
}
