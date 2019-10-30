package com.trilogyed.ZachMerelU1Capstone.controller;

import com.trilogyed.ZachMerelU1Capstone.dao.ConsoleDao;
import com.trilogyed.ZachMerelU1Capstone.exception.NotFoundException;
import com.trilogyed.ZachMerelU1Capstone.model.Console;
//import com.trilogyed.ZachMerelU1Capstone.service.InvoiceServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ConsoleController {

    @Autowired
    ConsoleDao consoleDao;

//    @Autowired
//    InvoiceServiceLayer invoiceServiceLayer;

    //GET ALL
    @GetMapping("/console")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsoles() {
        List<Console> consoles = consoleDao.getAllConsoles();
        return consoles;
    }
    //GET BY MANUFACTURER
    @GetMapping("/console/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsolesByManufacturer(@PathVariable String manufacturer) {
        List<Console> consoles = consoleDao.getAllConsolesByManufacturer(manufacturer);
        return consoles;
    }

    //GET BY ID
    @GetMapping("/console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id) {
        Console console = consoleDao.getConsole(id);
        return console;
    }


    //CREATE
    @PostMapping(value = "/console")
    @ResponseStatus(HttpStatus.CREATED)
    public Console createNewConsole(@RequestBody @Valid Console console) {
        return consoleDao.addConsole(console);
    }

    //DELETE
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
      consoleDao.deleteConsole(id);
    }

    //UPDATE
    @RequestMapping(value = "/console/{id}", method = RequestMethod.PUT)
    public Console updateConsoleById(@PathVariable int id, @RequestBody @Valid Console console) {
        if (id != console.getConsole_id()) {
            throw new IllegalArgumentException("The id in the path does not equal the id in the request body");
        }
        for(Console console1 : consoleDao.getAllConsoles()) {
            if(id == console1.getConsole_id()) {
                console.setConsole_id(id);
                consoleDao.updateConsole(console);
                return console;
            }
        }
        return null;
    }






}
