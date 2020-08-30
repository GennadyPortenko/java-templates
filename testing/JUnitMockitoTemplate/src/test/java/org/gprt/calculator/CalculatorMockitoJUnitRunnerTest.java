package org.gprt.calculator;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;

import org.gprt.numsupplier.NumSupplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorMockitoJUnitRunnerTest {
    /* @RunWith(MockitoJUnitRunner.class)  или  MockitoAnnotations.initMocks(this); */
    @Mock
    private NumSupplier numSupplier  = Mockito.mock(NumSupplier.class);

    @Mock
    private CalculatorInfo calculatorInfo;
    @InjectMocks     // требует наличия @RunWith(MockitoJUnitRunner.class)
    private static Calculator calculator;

    @BeforeClass
    public static void initCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void variousTestCases() {
        // с mock-объектом не происходило никаких взаимодействий ?
        Mockito.verifyZeroInteractions(numSupplier);

        // when().thenReturn()
        Mockito.when(numSupplier.supplyInts(10)).thenReturn(new int[] {1, 0, 2, 0, 3, 0, 4, 0, 5, 0});
        assertEquals(calculator.sumInts( numSupplier.supplyInts(10) ), 15 );

        Mockito.when(numSupplier.supplyAnyFloat()).thenReturn(new Float(0));
        Mockito.when(numSupplier.supplyAnyInt()).thenReturn(0);
        assertNotNull( numSupplier.supplyAnyFloat());

        // Mockito.verify()  позволяет проверять вызывался ли метод mock-Объекта, вызывался ли с оперделенными
        // параметрами, определенное количество раз и т.д.

        // вызывался ли метод mock-объекта
        Mockito.verify(numSupplier).supplyAnyFloat();
        // вызывался ли метод с определенным аргументом
        Mockito.verify(numSupplier).supplyInts(10);
        // вызывался ли метод с любым аргументом
        Mockito.verify(numSupplier).supplyInts(anyInt());
        // вызывался ли метод определенное число раз (в том числе 0)
        Mockito.verify(numSupplier, times(1)).supplyInts(anyInt());

        // захват и проверка аргумента вызванного метода mock-объекта
        numSupplier.toIncrementedIntArray(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        Mockito.verify(numSupplier).toIncrementedIntArray(argumentCaptor.capture());
        List<Integer> capturedArgument = argumentCaptor.<List<Integer>> getValue();
        assertThat(capturedArgument, hasItem(1));

        // Пример с @InjectMocks
        Mockito.when(calculatorInfo.getId()).thenReturn(20);
        assertEquals(calculator.getInfo().getId(), 20);

        // проверка на отсутствие дальнейшего взаимодествия mock-объекта
        Mockito.verifyNoMoreInteractions(numSupplier);
    }
}
