package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame (Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    List<Game> getAllGamesByStudio (String studio );

    List<Game> getAllGamesByEsrbRating(String esrb_rating);

    List<Game> getAllGamesByTitle (String title);

    void updateGame(Game game);

    void deleteGame(int id);
}
