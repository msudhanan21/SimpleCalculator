package com.SimpleCalculator.endpoints;

import com.SimpleCalculator.model.Calculation;
import com.SimpleCalculator.services.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorEndpointTest {

    @InjectMocks
    CalculatorEndpoint endpoint;

    @Mock
    CalculatorService service;

    @Test
    public void calculate() {
        double expected = 5.0;
        Mockito.when(service.calculate(10, -5,"A")).thenReturn(expected);
        Double actual = endpoint.calculate(10,-5,"A");
        assertEquals(expected,actual);
    }

    @Test
    public void getHistory() {
        List<Calculation> expected = Collections.singletonList(new Calculation());
        Mockito.when(service.getHistory()).thenReturn(expected);
        List<Calculation> actual = endpoint.getHistory();
        assertEquals(expected, actual);
    }
}