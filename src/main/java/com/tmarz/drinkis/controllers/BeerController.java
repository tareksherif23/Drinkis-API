package com.tmarz.drinkis.controllers;

import com.tmarz.drinkis.models.Beer;
import com.tmarz.drinkis.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController()
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @GetMapping()
    public ResponseEntity<List<Beer>> listBeers(){
        List<Beer> beerList =  beerService.listBeers();
        return new ResponseEntity<>(beerList, HttpStatus.OK);
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<Beer> getBeerById(@PathVariable("beerId") UUID id){
        Beer beer = beerService.getBeerById(id);
        return  new ResponseEntity<>(beer, HttpStatus.OK);
    }

    @PutMapping("{beerId}")
    public ResponseEntity<Beer> updateBeerById(@PathVariable("beerId") UUID id, @RequestBody Beer beer){
        Beer updated = beerService.updateBeerById(id, beer);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveBeer(@RequestBody Beer beer){
        log.debug("=== received beer object: " + beer);
        UUID beerId = beerService.saveBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Created-BeerId", beerId.toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID id) {
        beerService.deleteBeerById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
