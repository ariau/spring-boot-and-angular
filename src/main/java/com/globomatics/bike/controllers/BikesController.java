package com.globomatics.bike.controllers;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bikes")
@CrossOrigin("https://spring-boot-angular-app-hweveuhdbrghb2a9.eastus2-01.azurewebsites.net/")
public class BikesController {

  @Autowired
  private BikeRepository bikeRepository;

  @GetMapping
  public List<Bike> bikes() {
    List it = bikeRepository.findAll();

    List bikes = new ArrayList<Bike>();
    it.forEach(e -> bikes.add(e));

    return bikes;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void create(@RequestBody Bike bike) {
    bikeRepository.save(bike);
  }

  @GetMapping("/{id}")
  public Bike get(@PathVariable("id") Long id) {
    return bikeRepository.getOne(id);
  }
}
