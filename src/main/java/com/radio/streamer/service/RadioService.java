package com.radio.streamer.service;


import com.radio.streamer.persistence.entities.Kategorija;
import com.radio.streamer.persistence.entities.RadioStations;
import com.radio.streamer.persistence.entities.Zemlja;
import com.radio.streamer.persistence.repositories.CountryRepository;
import com.radio.streamer.persistence.repositories.RadioStationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RadioService {


    @Autowired
    private RadioStationsRepository radioStationsRepository;
    @Autowired
    private CountryRepository countryRepository;

    public List<RadioStations> getAllRadios(){
        List<RadioStations> radios = new ArrayList<>();
        radioStationsRepository.findAll().forEach(radios::add);
        return  radios;
    }

    public RadioStations getRadioById(int id){
        for (RadioStations r: radioStationsRepository.findAll()) {
            if(r.getId()==id) return r;
        }
        return null;
    }
    public RadioStations getRadioByName(String name){
        for (RadioStations r: radioStationsRepository.findAll()) {
            if(r.getName().equals(name)) return r;
        }
        return null;
    }
    public List<RadioStations> getAllRadiosByCountry(String name){
        List<RadioStations> radios= new ArrayList<>();
        Zemlja zem = new Zemlja();
        for (Zemlja z : countryRepository.findAll()
             ) { if(z.getName().equals(name)) zem=z;
        }
        for (RadioStations r: radioStationsRepository.findAll()) {
            if(r.getZemlja()==zem.getId())  radios.add(r);
        }
        return radios;
    }

    public List<RadioStations> getAllRadiosByCategory(String name){
        List<RadioStations> radios= new ArrayList<>();

        for (RadioStations r : radioStationsRepository.findAll()) {

            for (Kategorija k:r.getKategorija()) {
                if(k.getName().equals(name)) radios.add(r);
            }
        }
        return  radios;
    }

}
