package com.trilogyed.ZachMerelU1Capstone.controller;

import com.trilogyed.ZachMerelU1Capstone.dao.ConsoleDao;
import com.trilogyed.ZachMerelU1Capstone.dao.TShirtDao;
import com.trilogyed.ZachMerelU1Capstone.model.Console;
import com.trilogyed.ZachMerelU1Capstone.model.TShirt;
import com.trilogyed.ZachMerelU1Capstone.service.InvoiceServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TShirtController {


    @Autowired
    InvoiceServiceLayer invoiceServiceLayer;


    //GET ALL
    @GetMapping("/tshirt")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getAllTshirts() {
        List<TShirt> tShirts = invoiceServiceLayer.getAllTShirts();
        return tShirts;
    }


    //GET TSHIRT BY ID
    @GetMapping("/tshirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirt getTShirtById(@PathVariable int id) {
        TShirt tShirt = invoiceServiceLayer.getTShirt(id);
        return tShirt;
    }

    //DELETE
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) {
        invoiceServiceLayer.deleteTShirt(id);
    }

    //CREATE
    @PostMapping(value = "/tshirt")
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt createNewTShirt(@RequestBody @Valid TShirt tShirt) {

        return invoiceServiceLayer.addTShirt(tShirt);
    }

    //UPDATE
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.PUT)
    public void updateTShirtById(@PathVariable int id, @RequestBody @Valid TShirt tShirt) {
        if (id != tShirt.getT_shirt_id()) {
            throw new IllegalArgumentException("The id in the path does not equal the id in the request body");
        }
        for (TShirt tShirt1 : invoiceServiceLayer.getAllTShirts()) {
            if (id == tShirt1.getT_shirt_id()) {
                tShirt.setT_shirt_id(id);
                invoiceServiceLayer.updateTShirt(tShirt);
            }
        }
    }

    //GET TSHIRT BY COLOR
    @GetMapping("/tshirt/color/{color}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtByColor(@PathVariable String color) {
        List<TShirt> tShirts = invoiceServiceLayer.getAllTShirtsByColor(color);
        return tShirts;
    }

    //GET TSHIRT BY SIZE
    @GetMapping("/tshirt/size/{size}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtBySize(@PathVariable String size) {
        List<TShirt> tShirts = invoiceServiceLayer.getAllTShirtsBySize(size);
        return tShirts;
    }
}
