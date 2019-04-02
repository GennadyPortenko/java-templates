package org.gprt.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;

import org.gprt.numsupplier.NumSupplier;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorMockitoJUnitRunnerTest {
    /* @RunWith(MockitoJUnitRunner.class)  или  MockitoAnnotations.initMocks(this); */
    @Mock
    private NumSupplier numSupplier  = Mockito.mock(NumSupplier.class);
    private static Calculator calculator;

    @BeforeClass
    public static void initCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void testSumIntFromSupplier() {
        Mockito.when(numSupplier.supplyInts(10)).thenReturn(new int[] {1, 0, 2, 0, 3, 0, 4, 0, 5, 0});
        assertEquals(calculator.sumInts( numSupplier.supplyInts(10) ), 15 );
    }
}
