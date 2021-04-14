package com.SimpleCalculator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Calculation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private int number1;
    @Column
    private int number2;
    @Column
    private String operator;
    @Column
    private double result;
    @Column
    @JsonIgnore
    private LocalDateTime createdDateTime;
}
