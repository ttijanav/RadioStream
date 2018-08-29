package com.radio.streamer.controller;



import com.radio.streamer.persistence.entities.RadioStations;

import com.radio.streamer.persistence.entities.Zemlja;
import com.radio.streamer.persistence.repositories.CountryRepository;
import com.radio.streamer.persistence.repositories.RadioStationsRepository;
import com.radio.streamer.service.CountryService;
import com.radio.streamer.service.RadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RadioStationsController {

    @Autowired
    private RadioService radioService;
    private CountryService countryService;
    private CountryRepository countryRepository;


    @RequestMapping("/stations")
    public List<RadioStations> getAllRadios(){
        return radioService.getAllRadios();
    }

    @RequestMapping("/stations/{id}")
    public RadioStations getRadioById(@PathVariable int id){
        return radioService.getRadioById(id);
    }

    @RequestMapping(value = "/stations/name/{name}", method = RequestMethod.GET)
    public RadioStations getRadioByName(@PathVariable String name) {
        return  radioService.getRadioByName(name);
    }

    @RequestMapping(value = "/country/{name}", method = RequestMethod.GET)
    public List<RadioStations> getRadioByCountry(@PathVariable String name) {
        return radioService.getAllRadiosByCountry(name);
    }

    @RequestMapping(value = "/category/{name}", method = RequestMethod.GET)
    public List<RadioStations> getRadioByCategory(@PathVariable String name) {
        return radioService.getAllRadiosByCategory(name);
    }
}
