package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String CREATE_GAME_SQL =
            "insert into game(title, esrb_rating, description, price, studio, quantity) values (?,?,?,?,?,?)";
    private static final String GET_GAME_SQL =
            "select * from game where game_id = ?";
    private static final String GET_GAME_BY_STUDIO_SQL =
            "select * from game where studio = ?";
    private static final String GET_GAME_BY_ESRB_RATING_SQL =
            "select * from game where esrb_rating = ?";
    private static final String GET_GAME_BY_TITLE_SQL =
            "select * from game where title like ? ";
    private static final String DELETE_GAME_SQL =
            "delete from game where game_id = ?";
    private static final String GET_ALL_GAMES_SQL =
            "select * from game";
    private static final String UPDATE_GAME_SQL =
            "update game set title =?, esrb_rating =?, description =?, price =?, studio =?, quantity =?";


    @Override
    public Game addGame(Game game) {
        jdbcTemplate.update(CREATE_GAME_SQL,
                game.getTitle(),
                game.getEsrb_rating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        game.setGame_id(id);

        return game;
    }


    @Override
    public Game getGame(int id) {
        try{
            return jdbcTemplate.queryForObject(GET_GAME_SQL, this::mapRowToGame, id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no game with id " + id + "; message: " + erdae.getMessage());
            return null;
        }
    }


    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(GET_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public List<Game> getAllGamesByStudio(String studio) {
        try{
            return jdbcTemplate.query(GET_GAME_BY_STUDIO_SQL, this::mapRowToGame, studio);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no game with studio " + studio + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<Game> getAllGamesByEsrbRating(String esrb_rating) {
        try{
            return jdbcTemplate.query(GET_GAME_BY_ESRB_RATING_SQL, this::mapRowToGame, esrb_rating);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no game with studio " + esrb_rating + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<Game> getAllGamesByTitle(String title) {
        try{
            return jdbcTemplate.query(GET_GAME_BY_TITLE_SQL, this::mapRowToGame, "%" + title + "%");
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no game with studio " + title + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,game.getTitle(), game.getEsrb_rating(), game.getDescription(), game.getPrice(), game.getStudio(), game.getQuantity());

    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGame_id(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrb_rating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
