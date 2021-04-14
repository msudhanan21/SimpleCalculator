package com.SimpleCalculator.repo;

import com.SimpleCalculator.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepo extends JpaRepository<Calculation, Integer> {

}
