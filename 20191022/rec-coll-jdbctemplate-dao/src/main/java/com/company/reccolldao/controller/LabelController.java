package com.company.reccolldao.controller;

import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.service.ServiceLayer;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LabelController {
    @Autowired
    ServiceLayer serviceLayer;


    @RequestMapping(value = "/label", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Label createLabel(@RequestBody Label label) {
        return serviceLayer.updateLabel(label);
    }

    @RequestMapping(value = "/label", method = RequestMethod.GET)
    public List<Label> getAllLabels (){
        return serviceLayer.getAllLabels();
    }

    @RequestMapping(value = "/label/{id}", method = RequestMethod.GET)
    public Label getLabelById(@PathVariable int id){
        return serviceLayer.getLabel(id);
    }

    @RequestMapping(value = "/label/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabel(@PathVariable int id){
        serviceLayer.deleteLabel(id);
    }

    @RequestMapping(value = "/label/{id}", method = RequestMethod.PUT)
    public Label updateLabelById(@PathVariable int id, @RequestBody Label label){
        return serviceLayer.getLabel(id);
    }
}
