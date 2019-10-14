package com.trilogyed.cityserviceactivity.controller;

import com.trilogyed.cityserviceactivity.exceptions.CityNotFoundException;
import com.trilogyed.cityserviceactivity.models.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityController {

    private List<City> cities;

    public CityController(){
        cities = new ArrayList<City>();
        cities.add(new City("Chicago","Illinois", 2716000,false));
        cities.add(new City("Indianapolis", "Indiana",852506,true ));
        cities.add(new City("Boston", "Massachusetts", 645996,true ));
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public List<City> getAllCities() {

        return cities;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public City getCityByName(@PathVariable String name) {
        cities =
                cities.stream()
                        .filter(x -> x.getName().equals(name))
                        .collect(Collectors.toList());

        return cities.get(0);
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public City createNewCity(@RequestBody @Valid City city) throws Exception {
        if(city.getName().equals("")){
            throw new CityNotFoundException("You must supply a value for name.");
        }else if(city.getState().equals("")){
            throw new CityNotFoundException("You must supply a value for city.");
        }
        cities.add(city);
        return city;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecord(@PathVariable String name) {
        cities =
                cities.stream()
                        .filter(x -> x.getName().equals(name))
                        .collect(Collectors.toList());
    }

}
