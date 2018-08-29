package com.radio.streamer.persistence.repositories;

import com.radio.streamer.persistence.entities.Zemlja;
import org.springframework.data.repository.CrudRepository;


public interface CountryRepository extends CrudRepository<Zemlja, Integer> {

}
