package com.radio.streamer.persistence.repositories;

import com.radio.streamer.persistence.entities.Kategorija;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Kategorija,Integer> {
}
