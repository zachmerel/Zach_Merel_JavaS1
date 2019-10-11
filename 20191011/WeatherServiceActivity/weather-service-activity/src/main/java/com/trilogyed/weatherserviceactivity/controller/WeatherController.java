package com.trilogyed.weatherserviceactivity.controller;

import com.trilogyed.weatherserviceactivity.exceptions.ZipcodeNotFiveDigitsException;
import com.trilogyed.weatherserviceactivity.models.Conditions;
import com.trilogyed.weatherserviceactivity.models.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;



@RestController
public class WeatherController {
    private Temperature temperatures;
    private Conditions conditions;
 public Temperature()
    temperatures = new Temperature(32, 0);

    conditions = new Conditions(32, 0, 5, "NW", "Sunny", "none");


    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @RequestStatus(HttpStatus.OK)
    public Temperature getTemp(@PathVariable @Valid String zipcode) {
        Temperature returnVal = temperatures;
        if (zipcode.length() != 5){
            throw new ZipcodeNotFiveDigitsException("invalid input");
        }


        return returnVal;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @RequestStatus(HttpStatus.OK)
    public Temperature getTemp(@PathVariable @Valid String zipcode) {
        Conditions returnVal = conditions;
        if (zipcode.length() != 5) {
            throw new ZipcodeNotFiveDigitsException("invalid input");
        }


        return returnVal;
    }
}
