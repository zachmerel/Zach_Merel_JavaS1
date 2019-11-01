package com.trilogyed.ZachMerelU1Capstone.controller;


import com.trilogyed.ZachMerelU1Capstone.dao.ConsoleDao;
import com.trilogyed.ZachMerelU1Capstone.dao.GameDao;
import com.trilogyed.ZachMerelU1Capstone.model.Console;
import com.trilogyed.ZachMerelU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameDao gameDao;

    //GET ALL
    @GetMapping("/game")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        List<Game> games = gameDao.getAllGames();
        return games;
    }

    //GET GAME BY ID
    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable int id) {
        Game game = gameDao.getGame(id);
        return game;
    }

    //DELETE
    @RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        gameDao.deleteGame(id);
    }

    //CREATE
    @PostMapping(value = "/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createNewGame(@RequestBody @Valid Game game) {
        return gameDao.addGame(game);
    }

    //UPDATE
    @RequestMapping(value = "/game/{id}", method = RequestMethod.PUT)
    public Game updateGameById(@PathVariable int id, @RequestBody @Valid Game game) {
        if (id != game.getGame_id()) {
            throw new IllegalArgumentException("The id in the path does not equal the id in the request body");
        }
        for (Game game1 : gameDao.getAllGames()) {
            if (id == game1.getGame_id()) {
                game.setGame_id(id);
                gameDao.updateGame(game);
                return game;
            }
        }
        return null;
    }

    //GET GAME BY STUDIO
    @GetMapping("/game/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGamesByStudio(@PathVariable String studio) {
        List<Game> games = gameDao.getAllGamesByStudio(studio);
        return games;
    }

    //GET GAME BY ESRB_RATING
    @GetMapping("/game/esrb_rating/{esrb_rating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGamesByEsrbRating(@PathVariable String esrb_rating) {
        List<Game> games = gameDao.getAllGamesByEsrbRating(esrb_rating);
        return games;
    }

    //GET GAME BY TITLE
    @GetMapping("/game/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGamesByTitle(@PathVariable String title) {
        List<Game> games = gameDao.getAllGamesByTitle(title);
        return games;
    }
}
