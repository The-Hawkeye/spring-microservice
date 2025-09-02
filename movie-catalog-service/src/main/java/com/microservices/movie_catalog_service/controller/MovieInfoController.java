package com.microservices.movie_catalog_service.controller;

import com.microservices.movie_catalog_service.model.MovieInfo;
import com.microservices.movie_catalog_service.model.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieInfoController {

    @Autowired
    private MovieInfoRepository repository;

    @PostMapping("/movie-info/save")
    public List<MovieInfo> saveAll(@RequestBody List<MovieInfo> movies){
        return repository.saveAll(movies);
    }

    @GetMapping("/movie-info/list")
    public List<MovieInfo> getAll(){
        return repository.findAll();
    }
}
