package com.tmarz.drinkis.controllers;

import com.tmarz.drinkis.models.Beer;
import com.tmarz.drinkis.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController()
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @GetMapping()
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @GetMapping("/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID id){
        log.debug("Get beer by id called -- from controller with id: " + id);
        return beerService.getBeerById(id);
    }

    @PostMapping()
    public ResponseEntity saveBeer(@RequestBody Beer beer){
        log.debug("=== received beer object: " + beer);
        UUID beerId = beerService.saveBeer(beer);
        return new ResponseEntity(beerId, HttpStatus.CREATED);
    }

}
