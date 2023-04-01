package com.tmarz.drinkis.services;

import com.tmarz.drinkis.models.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer updateBeerById(UUID id, Beer beer);

    UUID saveBeer(Beer beer);

    void deleteBeerById(UUID id);
}
