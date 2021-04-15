package com.SimpleCalculator.services;

import com.SimpleCalculator.repo.CalculatorRepo;
import com.SimpleCalculator.model.Calculation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Simple calculator that do add, subtract, multiply, divide and also get history of operations
 * Please note that due to precision loss I would prefer BigDecimal than Double calculations
 */
@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculatorRepo calcRepo;

    /**
     * Would have used strategy pattern rather than switch if not asked for having class with add,subtract,multiply,divide methods
     * Parameters two numbers and operation to be done
     * @return the calculated result
     */
    public double calculate(int number1, int number2, String operator){

        switch (operator.toUpperCase()) {
            case "A": return add(number1, number2);
            case "S": return subtract(number1, number2);
            case "M": return multiply(number1, number2);
            case "D": return divide(number1, number2);
            default: throw new IllegalArgumentException("Unknown Operator");
        }
    }

    /**
     * @return The result of number1 + number2
     */
    public double add(int number1, int number2) {

        double result = number1 + number2;
        calcRepo.save(mapCalculator(number1, number2, "+", result));
        return result;
    }

    /**
     * @return The result of number1 - number2
     */
    public double subtract(int number1, int number2) {

        double result = number1 - number2;
        calcRepo.save(mapCalculator(number1, number2, "-", result));
        return result;
    }

    /**
     * @return The result of number1 * number2
     */
    public double multiply(int number1, int number2) {

        double result = number1 * number2;
        calcRepo.save(mapCalculator(number1, number2, "*", result));
        return result;
    }

    /**
     * @return The result of number1 / number2
     */
    public double divide(int number1, int number2) {

        double result = (double) number1 / (double) number2;
        calcRepo.save(mapCalculator(number1, number2, "/", result));
        return result;
    }

    /**
     * @return created new model object with mapped value
     */
    private Calculation mapCalculator(int number1, int number2, String operator, double result) {

        Calculation calc = new Calculation();
        calc.setNumber1(number1);
        calc.setNumber2(number2);
        calc.setOperator(operator);
        calc.setResult(result);
        calc.setCreatedDateTime(LocalDateTime.now());
        return calc;
    }

    /**
     * @return list of history form DB with sorted descending on created date time
     */
    public List<Calculation> getHistory() {

        return calcRepo.findAll(Sort.by(Sort.Direction.DESC, "createdDateTime"));
    }
}
