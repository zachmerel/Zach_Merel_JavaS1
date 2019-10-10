package com.company.recordstore.controller;

import com.company.recordstore.exceptions.RecordNotFoundException;
import com.company.recordstore.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecordStoreController {

    private List<Record> records;

    public RecordStoreController() {
        records = new ArrayList<Record>();
        records.add(new Record("Eagles", "Greatest Hits", "1973"));
        records.add(new Record("Beatles", "Sgt. Peppers Lonelyhearts Club Band", "1969"));
        records.add(new Record("21 Savage", "ISSA Album", "2018"));
        records.add(new Record("Hozier", "Wasteland Baby", "2017"));
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public List<Record> getAllRecords() {
        return records;
    }

    //@RequestMapping(value = "/records", method = RequestMethod.POST)
    @PostMapping(value = "/records")
    @ResponseStatus(HttpStatus.CREATED)
    public Record createNewRecord(@RequestBody @Valid Record record) {
        records.add(record);
        return record;
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecord(@PathVariable int id) {
        records =
                records.stream()
                .filter(x -> x.getId() != id)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.PUT)
    public Record updateRecordById(@PathVariable int id, @RequestBody @Valid Record record) {
        if (id != record.getId()) {
            throw new IllegalArgumentException("The id in the path does not equal the id in the request body");
        }
        for(Record record1 : records) {
            if(id == record1.getId()) {
                record.setId(id);
                records.set(records.indexOf(record1), record);
                return record;
            }
        }
        return null;
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Record getRecordById(@PathVariable int id) {
        for(Record record : records){
            if(id == record.getId()){
                return record;
            }else{
                throw new RecordNotFoundException("This id does not correspond to a record");
            }
        }

        return null;
    }
}
