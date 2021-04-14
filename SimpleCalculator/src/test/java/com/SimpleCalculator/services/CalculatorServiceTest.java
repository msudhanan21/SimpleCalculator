package com.SimpleCalculator.services;

import com.SimpleCalculator.repo.CalculatorRepo;
import com.SimpleCalculator.model.Calculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @Mock
    CalculatorRepo calculatorRepo;

    @InjectMocks
    CalculatorService service;

    @Test
    public void calculate() {
        assertEquals(2.0, service.calculate(1,1,"A"));
        assertEquals(-1.0, service.calculate(1,2,"S"));
        assertEquals(1.0, service.calculate(1,1,"M"));
        assertEquals(1.0, service.calculate(1,1,"D"));
    }

    @Test
    public void add() {
        assertEquals(0.0, service.add(0,0));
        assertEquals(-2.0, service.add(-1,-1));
        assertEquals(2.0, service.add(1,1));
        assertEquals(100.0, service.add(50,50));
        assertEquals(45.0, service.add(50,-5));
    }

    @Test
    public void subtract() {
        assertEquals(0.0, service.subtract(0,0));
        assertEquals(0.0, service.subtract(-1,-1));
        assertEquals(0.0, service.subtract(1,1));
        assertEquals(0.0, service.subtract(50,50));
        assertEquals(55.0, service.subtract(50,-5));
    }

    @Test
    public void multiply() {
        assertEquals(0.0, service.multiply(0,0));
        assertEquals(1.0, service.multiply(-1,-1));
        assertEquals(1.0, service.multiply(1,1));
        assertEquals(2500.0, service.multiply(50,50));
        assertEquals(-250.0, service.multiply(50,-5));
    }

    @Test
    public void divide() {
        assertEquals(1.0, service.divide(1,1));
        assertEquals(1.0, service.divide(-1,-1));
        assertEquals(1.0, service.divide(1,1));
        assertEquals(0.5, service.divide(5,10));
        assertEquals(-10.0, service.divide(50,-5));
    }

    @Test
    public void getHistory() {
        List<Calculation> expected = Collections.singletonList(new Calculation());
        Mockito.when(calculatorRepo.findAll(Mockito.any(Sort.class))).thenReturn(expected);
        List<Calculation> actual = service.getHistory();
        assertEquals(expected, actual);
    }
}