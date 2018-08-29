package com.radio.streamer.service;


import com.radio.streamer.persistence.entities.Zemlja;
import com.radio.streamer.persistence.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CountryService {



    @Autowired
    private CountryRepository countryRepository;

    public List<Zemlja> getAllCountries(){
        List<Zemlja> z = new ArrayList<>();
        countryRepository.findAll().forEach(z::add);
        return  z;
    }

    public Zemlja getCounryById(int id){
        for (Zemlja z: countryRepository.findAll()) {
            if(z.getId()==id) return z;
        }
        return null;
    }
    public Zemlja getCountryByName(String name){
        for (Zemlja z: countryRepository.findAll()) {
            System.out.println(z.getName());
            if(z.getName().equals(name)) return z;
        }
        return null;
    }

}
