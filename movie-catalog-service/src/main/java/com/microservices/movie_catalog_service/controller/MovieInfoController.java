package com.microservices.movie_catalog_service.controller;

import com.microservices.movie_catalog_service.model.MovieInfo;
import com.microservices.movie_catalog_service.model.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/movie-info/find-path-by-id/{movieInfoId}")
    public String findPathById(@PathVariable Long movieInfoId){
        Optional<MovieInfo> movieInfo = repository.findById(movieInfoId);
        return movieInfo.map(MovieInfo::getPath).orElse(null);
    }

}
