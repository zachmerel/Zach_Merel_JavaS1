package com.company.recordstore.controller;

import com.company.recordstore.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecordStoreController {

    private List<Record> records;

    public RecordStoreController(){
        records = new ArrayList<>();
        records.add(new Record("Eagles", "Greatest Hits"));
        records.add(new Record("Beatles", "Sgt. Peppers Lonelyhearts Club Band"));
        records.add(new Record("21 Savage", "ISSA Album"));
        records.add(new Record("Hozier", "Wasteland Baby"));
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public List<Record> getAllRecords() {
        return  records;
    }

    @PostMapping(value = "/records")
    @ResponseStatus(HttpStatus.CREATED)
    public Record createNewRecord(@RequestBody Record record) {
        records.add(record);
        return record;
    }

    @PutMapping(value = "/records/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Record updateNewRecord(@RequestBody Record record, @PathVariable int id) {
        records.set(id-1,record);
        return records.get(id-1);
    }

    @GetMapping(value = "/records/{id}")
    public Record retrievedARecord(@PathVariable int id) {
        return records.get(id);

    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecord(@PathVariable int id){
     records = records.stream().filter(x  -> x.getId() != id ).collect(Collectors.toList());
    }
}
