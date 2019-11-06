package com.trilogyed.zachmerelmagiceightballservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class MagicEightBallController {
    private Random randomGenorator;

    List<String> listOfAnswers = new ArrayList<String>(){{
        add("No");
        add("Yes");
        add("Looking cloudy");
        add("Not sure");
        add("Absolutely!");
        add("Ask again");
        add("Ummm");
        add("Not a chance");
    }};




    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String randomAnswer(){
        randomGenorator = new Random();
        return listOfAnswers.get(new Random().nextInt(listOfAnswers.size()));
    }
}
