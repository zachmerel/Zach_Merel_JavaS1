package com.company.reccolldao.controller;

import com.company.reccolldao.model.Album;
import com.company.reccolldao.service.ServiceLayer;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/album", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumViewModel createAlbum(@RequestBody AlbumViewModel albumViewModel) {
        return serviceLayer.saveAlbum(albumViewModel);
    }

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public List<Album> getAllAlbums (){
        return serviceLayer.getAllAlbums();
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public Album getAlbumById(@PathVariable int id){
        return serviceLayer.getAlbum(id);
    }

    @RequestMapping(value = "/album/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable int id){
        serviceLayer.deleteAlbum(id);
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.PUT)
    public Album updateAlbumById(@PathVariable int id, @RequestBody AlbumViewModel albumViewModel){
        return serviceLayer.getAlbum(id);
    }
}
