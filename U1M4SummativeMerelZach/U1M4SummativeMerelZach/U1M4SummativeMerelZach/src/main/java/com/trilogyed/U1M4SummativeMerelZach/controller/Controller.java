package com.trilogyed.U1M4SummativeMerelZach.controller;


import com.trilogyed.U1M4SummativeMerelZach.models.Answer;
import com.trilogyed.U1M4SummativeMerelZach.models.Definition;
import com.trilogyed.U1M4SummativeMerelZach.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Controller {

    private List<Answer> answersAndQuestions;
    private List<Quote> quotes;
    private List<Definition> words;

    Random randomGenerator = new Random();

    public Controller() {
        //Magic 8 Ball Responses
        answersAndQuestions = new ArrayList<Answer>();
        answersAndQuestions.add(new Answer("It is certain."));
        answersAndQuestions.add(new Answer("My sources say no."));
        answersAndQuestions.add((new Answer("Without a doubt.")));
        answersAndQuestions.add(new Answer("Cannot predict now"));
        answersAndQuestions.add(new Answer("It is decidedly so."));
        answersAndQuestions.add(new Answer("Don't count on it."));

        //Word and Definition Data
        words = new ArrayList<Definition>();
        words.add(new Definition("consider", "deem to be"));
        words.add(new Definition("minute", "infinitely or immeasurably small"));
        words.add(new Definition("accord", "concurrence of opinion"));
        words.add(new Definition("evident", "clearly revealed to the mind or the senses or judgment"));
        words.add(new Definition("practice", "a customary way of operation or behavior"));
        words.add(new Definition("intend", "have in mind as a purpose"));
        words.add(new Definition("concern", "something that interests you because it is important"));
        words.add(new Definition("commit", "perform an act, usually with a negative connotation"));
        words.add(new Definition("issue", "some situation or event that is thought about"));
        words.add(new Definition("approach", "move towards"));

        //Quotes and Author Data
        quotes = new ArrayList<Quote>();
        quotes.add(new Quote("I'm going to make him an offer he can't refuse.", "The Godfather"));
        quotes.add(new Quote("May the Force be with you.", "Han Solo"));
        quotes.add(new Quote("You talking to me?", "Travis Bickle"));
        quotes.add(new Quote("I love the smell of napalm in the morning.", "Lieutenant Colonel Bill Kilgore"));
        quotes.add(new Quote("E.T. phone home.", "E.T."));
        quotes.add(new Quote("A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.", "Hannibal Lecter"));
        quotes.add(new Quote("Bond. James Bond.", "James Bond"));
        quotes.add(new Quote("Show me the Money!", "Jerry Maguire"));
        quotes.add(new Quote("You can't handle the truth!", "Col. Nathan R. Jessep"));
        quotes.add(new Quote("I'll be back.", "The terminator"));
        quotes.add(new Quote("You've got to ask yourself one question: 'Do I feel lucky?' Well, do ya, punk?", "Dirty Harry"));
        quotes.add(new Quote("Here's Johnny!", "Jack Torrance"));
        quotes.add(new Quote("Yo, Adrian!", "Rocky Balboa "));
        quotes.add(new Quote("My precious.", "Gollum"));
        quotes.add(new Quote("The first rule of Fight Club is: You do not talk about Fight Club. The second rule of Fight Club is: You do not talk about Fight Club. ", "Tyler Durden", 15));
        quotes.add(new Quote("Ogres are like onions", "Shrek"));
        quotes.add(new Quote("You're my boy blue!", "Frank the Tank"));
        quotes.add(new Quote("I am Groot", "Groot"));
        quotes.add(new Quote("Cello, you've got a bass", "Dewey Finn"));
        quotes.add(new Quote("With great power comes great responsibility", "Uncle Ben"));
        quotes.add(new Quote("What is this? A center for ants?", "Derek Zoolander"));
        quotes.add(new Quote("Wilsooooooooon!", "Chuck Noland"));
        quotes.add(new Quote("Why so serious", "The Joker"));
        quotes.add(new Quote("You shall not pass!", "Gandalf the Grey"));
        quotes.add(new Quote("Are you not entertained", "Maximus Decimus Meridius"));
        quotes.add(new Quote("I'm in a glass cage of emotion", "Ron Burgundy"));
        quotes.add(new Quote("Mm-hmm! This is a tasty burger!", "Jules Winnfield "));
        quotes.add(new Quote("When I was your age, television was called books.", "William Goldman"));

    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Answer createNewAnswer(@RequestBody @Valid Answer question) {
        Answer generatedAnswer =
                answersAndQuestions.get(randomGenerator.nextInt(answersAndQuestions.size()));
        generatedAnswer.setQuestion(question.getQuestion());
        return generatedAnswer;
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getAQuote() {
        Quote generatedQuote =
                quotes.get(randomGenerator.nextInt(quotes.size()));
        return generatedQuote;
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Definition getAWord() {
        Definition generatedDefinition =
                words.get(randomGenerator.nextInt(words.size()));
        return generatedDefinition;
    }


}
