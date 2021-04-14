package com.SimpleCalculator.endpoints;

import com.SimpleCalculator.model.Calculation;
import com.SimpleCalculator.services.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Provides endpoint for calculating and also to see the history as per the request
 * @author Madhu Sudhanan
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CalculatorEndpoint {

    private final CalculatorService calcService;

    @GetMapping("/calc")
    public Double calculate(
            @RequestParam("num1") int number1,
            @RequestParam("num2") int number2,
            @RequestParam("operator") String operator) {

        return calcService.calculate(number1,number2,operator);
    }

    @GetMapping("/getHistory")
    public List<Calculation> getHistory(){

        return calcService.getHistory();
    }
}
