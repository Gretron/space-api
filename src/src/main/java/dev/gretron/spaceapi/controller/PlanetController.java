package dev.gretron.spaceapi.controller;

import dev.gretron.spaceapi.model.PaginatedEntity;
import dev.gretron.spaceapi.model.PlanetDto;
import dev.gretron.spaceapi.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


// @CrossOrigin()
@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Mono<PaginatedEntity<PlanetDto>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                   @RequestParam(value = "size", defaultValue = "10") int size) {

        return planetService.getAllPlanets(PageRequest.of(page, size));

    }

}
