package com.trilogyed.ZachMerelU1Capstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.ZachMerelU1Capstone.dao.ConsoleDao;
import com.trilogyed.ZachMerelU1Capstone.dao.GameDao;
import com.trilogyed.ZachMerelU1Capstone.model.Console;
import com.trilogyed.ZachMerelU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameDao gameDao;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    //a List of Games for testing purposes
    private List<Game> gameList;
    private List<Game> studioList;
    private List<Game> titleList;
    private List<Game> esrbRatingList;

    @Before
    public void setUp() throws Exception {
        gameList = new ArrayList<>();
        gameList.add(new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        gameList.add(new Game(2, "Grand Theft Auto: San Andres", "Mature", "Grand Theft Auto: San Andres is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        gameList.add(new Game(3, "Grand Theft Auto: V", "Mature", "Grand Theft Auto: V is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));

        titleList = new ArrayList<>();
        titleList.add(new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        titleList.add(new Game(2, "Grand Theft Auto: San Andres", "Mature", "Grand Theft Auto: San Andres is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        titleList.add(new Game(3, "Grand Theft Auto: V", "Mature", "Grand Theft Auto: V is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));

        studioList = new ArrayList<>();
        studioList.add(new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        studioList.add(new Game(2, "Grand Theft Auto: San Andres", "Mature", "Grand Theft Auto: San Andres is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        studioList.add(new Game(3, "Grand Theft Auto: V", "Mature", "Grand Theft Auto: V is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));

        esrbRatingList = new ArrayList<>();
        esrbRatingList.add(new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        esrbRatingList.add(new Game(2, "Grand Theft Auto: San Andres", "Mature", "Grand Theft Auto: San Andres is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        esrbRatingList.add(new Game(3, "Grand Theft Auto: V", "Mature", "Grand Theft Auto: V is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));

        Game createMockGameObject = new Game("Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20);
        //GET ALL MOCK
        when(gameDao.getAllGames()).thenReturn(gameList);
        //GET GAME BY ID MOCK
        when(gameDao.getGame(1)).thenReturn(gameList.get(0));
        //CREATE GAME MOCK
        when(gameDao.addGame(createMockGameObject)).thenReturn(gameList.get(0));
        //GET GAME BY TITLE MOCK
        when(gameDao.getAllGamesByTitle("Grand Theft Auto: Vice City")).thenReturn(titleList);
        //GET GAME BY ESRB_RATING MOCK
        when(gameDao.getAllGamesByEsrbRating("Mature")).thenReturn(esrbRatingList);
        //GET GAME BY STUDIO MOCK
        when(gameDao.getAllGamesByStudio("Rockstar North")).thenReturn(studioList);
        //UPDATE GAME RETURNS VOID SO NO MOCK POSSIBLE

    }

    //GET ALL
    //assert
    @Test
    public void shouldReturnAllGames() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(gameList);

        // act
        mockMvc
                .perform(get("/game"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    //GET BY ID
    @Test
    public void shouldGetAGameById() throws Exception {
        String outputJson = mapper.writeValueAsString(new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        // act
        mockMvc
                .perform(get("/game/{id}", 1))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    //DELETE
    @Test
    public void shouldDeleteAGame() throws Exception {
        //act
        mockMvc.perform(
                delete("/game/{id}", 1)
        )
                .andDo(print())
                .andExpect(status().isNoContent());          //assert

    }

    //CREATE
    @Test
    public void shouldCreateANewGame() throws Exception {
        //arrange
        String inputJson = mapper.writeValueAsString(new Game( "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));
        String outputJson = mapper.writeValueAsString(new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20));

        // act
        mockMvc.perform(
                post("/game")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(outputJson));         // our json should match

    }

    //UPDATE
    @Test
    public void shouldUpdateGame() throws Exception {
        // arrange
        Game inputAndOutputRecordForPut = new Game(1, "Grand Theft Auto: IV", "Mature", "Grand Theft Auto: IV is an action-adventure video game", BigDecimal.valueOf(19.99), "Rockstar North", 20);
        String inputAndOutputJson = mapper.writeValueAsString(inputAndOutputRecordForPut);
        //String outputJson = mapper.writeValueAsString(inputAndOutRecordForPut);

        mockMvc.perform(
                put("/game/{id}", 1)     // act
                        .content(inputAndOutputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                 // assert
                .andExpect(content().json(inputAndOutputJson));
    }

    //GET GAME BY STUDIO
    @Test
    public void shouldGetGameByStudio() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(studioList);

        // act
        mockMvc
                .perform(get("/game/studio/{studio}", "Rockstar North"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.
    }

    //GET GAME BY ESRB_RATING
    @Test
    public void shouldGetGameByEsrbRating() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(esrbRatingList);

        // act
        mockMvc
                .perform(get("/game/esrb_rating/{esrb_rating}", "Mature"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.
    }

    //GET GAME BY TITLE
    @Test
    public void shouldGetGameByTitle() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(titleList);

        // act
        mockMvc
                .perform(get("/game/title/{title}", "Grand Theft Auto: Vice City"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.
    }

}
