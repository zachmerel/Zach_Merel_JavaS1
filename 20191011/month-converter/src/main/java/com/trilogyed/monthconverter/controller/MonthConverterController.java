package com.trilogyed.monthconverter.controller;

import com.trilogyed.monthconverter.exception.InputOutOfRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthConverterController {

    public String translateIntegerToMonthName(int myInput) {
        switch(myInput) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return null;
    }

    @RequestMapping(value = "/day/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getMonthName(@PathVariable int monthNumber) {
        if (monthNumber > 12 || monthNumber < 1) {
            throw new InputOutOfRangeException("invalid input");
        }
        return translateIntegerToMonthName(monthNumber);
    }


}
