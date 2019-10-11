package com.trilogyed.calculatorserviceactivity.controller;

import com.trilogyed.calculatorserviceactivity.Calculator;
import com.trilogyed.calculatorserviceactivity.models.NumberPair;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
public class CalculatorController {
    Calculator doMath = new Calculator();

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public double add(@RequestParam @Valid int numberA,@RequestParam @Valid int numberB){
       return doMath.add(numberA, numberB);

    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public double subtract(@RequestParam @Valid int numberA,@RequestParam @Valid int numberB){
        return doMath.subtract(numberA, numberB);

    }

    @RequestMapping(value = "/mult", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public double mult(@RequestParam @Valid int numberA,@RequestParam @Valid int numberB){
        return doMath.mult(numberA, numberB);

    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public double divide(@RequestParam @Valid int numberA,@RequestParam @Valid int numberB){
        return doMath.divide(numberA, numberB);

    }


}
