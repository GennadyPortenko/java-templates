package org.gprt.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.mockito.MockitoAnnotations;

import org.gprt.numsupplier.NumSupplier;
import org.junit.*;

import org.mockito.Mockito;


public class CalculatorTest {
  private static Calculator calculator;
  private final double DELTA = 1e-15;

  @BeforeClass
  public static void initCalculator() {
    calculator = new Calculator();
  }

  @Before
  public void beforeEachTest() {
    System.out.println("Starting test case...");
  }

  @After
  public void afterEachTest() {
    System.out.println("Test case finished");
  }

  @Test
  public void testSumInt() {
    assertEquals(5, calculator.sumInt(2, 3));
  }

  @Test
  public void testMultiplyThreeNumbers() {
    assertEquals(7.5d, calculator.multiply(1.25d, 2d, 3d), DELTA);
  }

  @Ignore
  @Test
  public void testMultiplyTwoNumbers() {
    assertEquals(3, calculator.multiply(1.5d, 2d), DELTA);
  }

  @Test
  public void testMultiplyFourNumbers() {
    double result = calculator.multiply(1, 2, 3, 4);
    assertTrue( ((Double)result).intValue() == 24);
  }

  @Test
  public void testSum2() {
    int result = calculator.sumInt(1, 0);
    assertFalse(result == 0);
  }

  @Test
  public void testDivision() {
    try {
      assertEquals(3, calculator.divideInt(6, 2));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test(expected = Exception.class)
  public void testDivisionByZero() throws Exception {
      calculator.divideInt(1, 0);
  }

  @Test
  // Mockito init and test example
  public void testSumIntFromSupplier() {
    MockitoAnnotations.initMocks(this);
    NumSupplier numSupplier  = Mockito.mock(NumSupplier.class);
    Mockito.when(numSupplier.supplyInts(10)).thenReturn(new int[] {1, 0, 2, 0, 3, 0, 4, 0, 5, 0});
    assertEquals(calculator.sumInts( numSupplier.supplyInts(10) ), 15 );
  }
}
