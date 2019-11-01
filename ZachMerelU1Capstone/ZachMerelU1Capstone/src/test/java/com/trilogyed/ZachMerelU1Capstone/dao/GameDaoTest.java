package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    private GameDao gameDao;
    @Autowired
    private ConsoleDao consoleDao;
    @Autowired
    private TShirtDao tShirtDao;
    @Autowired
    private TaxesDao taxesDao;
    @Autowired
    private ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        gameDao.getAllGames()
                .stream()
                .forEach(game -> gameDao.deleteGame(game.getGame_id()));
    }

    @Test
    public void shouldAddGetDeleteGame() {
        //arrange
        Game gameToInsert = new Game();
        gameToInsert.setTitle("Grand Theft Auto: Vice City");
        gameToInsert.setEsrb_rating("Mature");
        gameToInsert.setDescription("Grand Theft Auto: Vice City is an action-adventure video game");
        gameToInsert.setPrice(BigDecimal.valueOf(19.99));
        gameToInsert.setStudio("Rockstar North");
        gameToInsert.setQuantity(1);
        //act

        Game gameAfterInsert = gameDao.addGame(gameToInsert);

        Game gameIExpect = new Game();
        gameIExpect.setGame_id(gameAfterInsert.getGame_id());
        gameIExpect.setTitle("Grand Theft Auto: Vice City");
        gameIExpect.setEsrb_rating("Mature");
        gameIExpect.setDescription("Grand Theft Auto: Vice City is an action-adventure video game");
        gameIExpect.setPrice(BigDecimal.valueOf(19.99));
        gameIExpect.setStudio("Rockstar North");
        gameIExpect.setQuantity(1);

        Game gameIGot = gameDao.getGame(gameAfterInsert.getGame_id());

        //assert
        assertEquals(gameIExpect, gameIGot);

        gameDao.deleteGame(gameIExpect.getGame_id());

        gameIExpect = gameDao.getGame(gameIExpect.getGame_id());

        assertNull(gameIExpect);

    }

    //Test should be fulfilled by the shouldAddGetDeleteGame Test
//    @Test
//    public void addGame() {
//    }
//
//    @Test
//    public void getGame() {
//    }
//
//    @Test
//    public void deleteGame() {
//    }

    @Test
    public void getAllGames() {
        //arrange
        Game game1 = new Game();
        game1.setTitle("Grand Theft Auto: Vice City");
        game1.setEsrb_rating("Mature");
        game1.setDescription("Grand Theft Auto: Vice City is an action-adventure video game");
        game1.setPrice(BigDecimal.valueOf(19.99));
        game1.setStudio("Rockstar North");
        game1.setQuantity(1);

        Game game2 = new Game();
        game2.setTitle("Grand Theft Auto: San Andres");
        game2.setEsrb_rating("Mature");
        game2.setDescription("Grand Theft Auto: San Andres is an action-adventure video game");
        game2.setPrice(BigDecimal.valueOf(19.99));
        game2.setStudio("Rockstar North");
        game2.setQuantity(1);

        gameDao.addGame(game1);
        gameDao.addGame(game2);

        //act
        List<Game> games = gameDao.getAllGames();

        //assert
        assertEquals(2, games.size());
    }

    @Test
    public void getAllGamesByStudio() {
        //arrange
        Game game1 = new Game();
        game1.setTitle("Grand Theft Auto: Vice City");
        game1.setEsrb_rating("Mature");
        game1.setDescription("Grand Theft Auto: Vice City is an action-adventure video game");
        game1.setPrice(BigDecimal.valueOf(19.99));
        game1.setStudio("Rockstar North");
        game1.setQuantity(1);

        Game game2 = new Game();
        game2.setTitle("Grand Theft Auto: San Andres");
        game2.setEsrb_rating("Mature");
        game2.setDescription("Grand Theft Auto: San Andres is an action-adventure video game");
        game2.setPrice(BigDecimal.valueOf(19.99));
        game2.setStudio("Rockstar North");
        game2.setQuantity(1);

        gameDao.addGame(game1);
        gameDao.addGame(game2);

        //act
        List<Game> games = gameDao.getAllGamesByStudio("Rockstar North");

        //assert
        assertEquals(2, games.size());
    }

    @Test
    public void getAllGamesByEsrbRating() {
        //arrange
        Game game1 = new Game();
        game1.setTitle("Grand Theft Auto: Vice City");
        game1.setEsrb_rating("Mature");
        game1.setDescription("Grand Theft Auto: Vice City is an action-adventure video game");
        game1.setPrice(BigDecimal.valueOf(19.99));
        game1.setStudio("Rockstar North");
        game1.setQuantity(1);

        Game game2 = new Game();
        game2.setTitle("Grand Theft Auto: San Andres");
        game2.setEsrb_rating("Mature");
        game2.setDescription("Grand Theft Auto: San Andres is an action-adventure video game");
        game2.setPrice(BigDecimal.valueOf(19.99));
        game2.setStudio("Rockstar North");
        game2.setQuantity(1);

        gameDao.addGame(game1);
        gameDao.addGame(game2);

        //act
        List<Game> games = gameDao.getAllGamesByEsrbRating("Mature");

        //assert
        assertEquals(2, games.size());
    }

    @Test
    public void getAllGamesByTitle() {
        //arrange
        Game game1 = new Game();
        game1.setTitle("Grand Theft Auto: Vice City");
        game1.setEsrb_rating("Mature");
        game1.setDescription("Grand Theft Auto: Vice City is an action-adventure video game");
        game1.setPrice(BigDecimal.valueOf(19.99));
        game1.setStudio("Rockstar North");
        game1.setQuantity(1);

        gameDao.addGame(game1);
        gameDao.addGame(game1);


        //act
        List<Game> games = gameDao.getAllGamesByTitle("Grand Theft Auto: Vice City");

        //assert
        assertEquals(2, games.size());
    }

    @Test
    public void updateGame() {
        //arrange
        Game gameToInsert = new Game();
        gameToInsert.setTitle("Grand Theft Auto: Vice City");
        gameToInsert.setEsrb_rating("Mature");
        gameToInsert.setDescription("Grand Theft Auto: Vice City is an action-adventure video game");
        gameToInsert.setPrice(BigDecimal.valueOf(19.99));
        gameToInsert.setStudio("Rockstar North");
        gameToInsert.setQuantity(1);

        Game gameAfterInsert = gameDao.addGame(gameToInsert);

        Game gameUpdate = new Game();
        gameUpdate.setGame_id(gameAfterInsert.getGame_id());
        gameUpdate.setTitle("Grand Theft Auto: San Andres");
        gameUpdate.setEsrb_rating("Mature");
        gameUpdate.setDescription("Grand Theft Auto: San Andres is an action-adventure video game");
        gameUpdate.setPrice(BigDecimal.valueOf(19.99));
        gameUpdate.setStudio("Rockstar North");
        gameUpdate.setQuantity(1);

        Game gameIExpect = new Game();
        gameIExpect.setGame_id(gameAfterInsert.getGame_id());
        gameIExpect.setTitle("Grand Theft Auto: San Andres");
        gameIExpect.setEsrb_rating("Mature");
        gameIExpect.setDescription("Grand Theft Auto: San Andres is an action-adventure video game");
        gameIExpect.setPrice(BigDecimal.valueOf(19.99));
        gameIExpect.setStudio("Rockstar North");
        gameIExpect.setQuantity(1);

        //act
        gameDao.updateGame(gameUpdate);
        Game gameIGot = gameDao.getGame(gameIExpect.getGame_id());

        //assert
        assertEquals(gameIExpect, gameIGot);
    }

}