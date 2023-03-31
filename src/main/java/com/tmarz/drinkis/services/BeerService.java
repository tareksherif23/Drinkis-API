package com.tmarz.drinkis.services;

import com.tmarz.drinkis.models.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    UUID saveBeer(Beer beer);
}
