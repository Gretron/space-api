package dev.gretron.spaceapi.controller;

import dev.gretron.spaceapi.model.AsteroidDto;
import dev.gretron.spaceapi.model.PaginatedEntity;
import dev.gretron.spaceapi.service.AsteroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/asteroids")
public class AsteroidController {

    @Autowired
    AsteroidService asteroidService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Mono<PaginatedEntity<AsteroidDto>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size) {

        return asteroidService.getAllAsteroids(PageRequest.of(page, size));

    }

}
