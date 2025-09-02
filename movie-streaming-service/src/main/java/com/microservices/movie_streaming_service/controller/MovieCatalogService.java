package com.microservices.movie_streaming_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieCatalogService {

    public static final String CATALOG_ENDPOINT = "http://movie-catalog-service";

    @Autowired
    private RestTemplate restTemplate;

    public String getMoviePath(Long movieId){
        var response = restTemplate.getForEntity(CATALOG_ENDPOINT + "/movie-info/find-path-by-id/{movieInfoId}", String.class, movieId);
        return response.getBody();
    }
}
