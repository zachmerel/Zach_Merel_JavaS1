package com.trilogyed.ZachMerelU1Capstone.controller;

import com.trilogyed.ZachMerelU1Capstone.model.InputObject;
import com.trilogyed.ZachMerelU1Capstone.model.Invoice;
import com.trilogyed.ZachMerelU1Capstone.service.InvoiceServiceLayer;
import com.trilogyed.ZachMerelU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceServiceLayer invoiceService;


    @PostMapping(value = "/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createNewInvoice(@RequestBody @Valid InputObject inputObject) {
        return invoiceService.makeAPurchase(inputObject);
    }
}
