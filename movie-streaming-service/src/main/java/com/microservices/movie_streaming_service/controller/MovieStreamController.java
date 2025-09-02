package com.microservices.movie_streaming_service.controller;

import org.apache.hc.core5.http.io.entity.InputStreamEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
public class MovieStreamController {

    private static final Logger logger = LoggerFactory.getLogger(MovieStreamController.class);
    private static final String VIDEO_PATH = "/Users/anubhavmaurya/Desktop/";

    @GetMapping("/stream/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) throws FileNotFoundException {
        File file = new File(VIDEO_PATH + videoPath);
        logger.info("dfklsdfkdjslfjkdjkfjdjfksjfl");
        logger.info(file.getAbsolutePath());
        if(file.exists()){
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(inputStreamResource);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
