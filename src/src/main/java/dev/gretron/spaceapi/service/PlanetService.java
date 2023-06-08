package dev.gretron.spaceapi.service;

import dev.gretron.spaceapi.model.AsteroidDto;
import dev.gretron.spaceapi.model.PaginatedEntity;
import dev.gretron.spaceapi.model.PlanetDto;
import dev.gretron.spaceapi.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    public Mono<PaginatedEntity<PlanetDto>> getAllPlanets(Pageable pageable) {

        return planetRepository.count()
                .log()
                .flatMap(count -> planetRepository.findAll()
                        .log()
                        .skip(pageable.getPageNumber() * pageable.getPageSize())
                        .take(pageable.getPageSize())
                        .collectList()
                        .map(list -> new PaginatedEntity<PlanetDto>(list, pageable.getPageNumber(), pageable.getPageSize(), count)));

    }

}
