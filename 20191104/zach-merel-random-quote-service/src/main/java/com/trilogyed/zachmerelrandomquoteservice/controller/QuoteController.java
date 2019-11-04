package com.trilogyed.zachmerelrandomquoteservice.controller;

import org.springframework.beans.factory.annotation.Value;
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
public class QuoteController {

    private Random randomGenorator;

   List<String> listOfQuotes = new ArrayList<String>(){{
       add("To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge. - Grace Hopper");
       add("Programs must be written for people to read, and only incidentally for machines to execute. - Hal Ableson");
       add("Don't call me the mother of the internet. - Radia Perlman");
       add("When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline. - Margaret Hamilton");
       add("Machines take me by surprise with great frequency. - Alan Turing");
       add("The function of good software is to make the complex appear simple. - Grady Booch");
       add("An API that isn't comprehensible isn't usable. - James Gosling");
       add("I'm not a great programmer; I'm just a good programmer with great habits. - Martin Fowler");
   }};




    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String randomQuote(){
        randomGenorator = new Random();
        return listOfQuotes.get(new Random().nextInt(listOfQuotes.size()));
    }
}
