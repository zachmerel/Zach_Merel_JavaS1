package com.company.reccolldao.controller;

import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {
    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/artist", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody Artist artist) {
        Artist myNewArtist = serviceLayer.addArtist(artist);
        return myNewArtist;
    }

    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public List<Artist> getAllArtist (){
        return serviceLayer.getAllArtists();
    }

    @RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
    public Artist getArtistById(@PathVariable int id){
        return serviceLayer.getArtist(id);
    }

    @RequestMapping(value = "/artist/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable int id){
        serviceLayer.deleteArtist(id);
    }

    @RequestMapping(value = "/artist/{id}", method = RequestMethod.PUT)
    public Artist updateArtistById(@PathVariable int id, @RequestBody Artist artist){
        return serviceLayer.getArtist(id);
    }
}
